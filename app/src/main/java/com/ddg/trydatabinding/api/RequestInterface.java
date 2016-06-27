package com.ddg.trydatabinding.api;

import com.ddg.trydatabinding.responce.AndroidResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface RequestInterface {

    @GET("android/jsonandroid")
    Observable<AndroidResponse> getAndroids();
}