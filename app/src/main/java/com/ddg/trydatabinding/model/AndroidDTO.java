package com.ddg.trydatabinding.model;

import com.google.gson.annotations.SerializedName;

public class AndroidDTO {

    @SerializedName("ver")
    String version;

    @SerializedName("name")
    String name;

    @SerializedName("api")
    String api;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
