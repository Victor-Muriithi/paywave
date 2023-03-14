package com.example.signuploginrealtime.Interceptor;

import android.util.Base64;

import androidx.annotation.NonNull;

import com.example.signuploginrealtime.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AccessTokenInterceptor {
    public AccessTokenInterceptor() {

    }

    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {

        String keys = new StringBuilder().append(BuildConfig.CONSUMER_KEY).append(BuildConfig.CONSUMER_SECRET).toString();

        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Basic " + Base64.encodeToString(keys.getBytes(), Base64.NO_WRAP))
                .build();
        return chain.proceed(request);
    }
}
