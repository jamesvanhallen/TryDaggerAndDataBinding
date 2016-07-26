package com.ddg.trydatabinding.api;

import com.ddg.trydatabinding.response.AndroidResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface RequestInterface {

    @GET("android/jsonandroid")
    Observable<AndroidResponse> getAndroids();
}