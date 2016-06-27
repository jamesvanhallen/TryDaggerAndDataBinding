package com.ddg.trydatabinding.responce;

import com.ddg.trydatabinding.model.AndroidDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AndroidResponse {

    @SerializedName("android")
    private List<AndroidDTO> mAndroidsList;

    public List<AndroidDTO> getAndroidsList() {
        return mAndroidsList;
    }

    public void setAndroidsList(List<AndroidDTO> androidsList) {
        mAndroidsList = androidsList;
    }
}
