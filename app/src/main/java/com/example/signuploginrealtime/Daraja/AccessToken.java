package com.example.signuploginrealtime.Daraja;
import com.google.gson.annotations.*;


public class AccessToken {
    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("expires_in")
    @Expose private String expiresIn;

    public AccessToken(String accessToken, String expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}




