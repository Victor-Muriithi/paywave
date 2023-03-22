package com.example.paywave.Interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public interface Intercept {
    Response intercept(@NonNull Interceptor.Chain chain) throws IOException;
}
