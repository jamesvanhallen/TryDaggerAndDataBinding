package com.ddg.trydatabinding.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AndroidDTO {

    @SerializedName("ver")
    String version;

    @SerializedName("name")
    String name;

    @SerializedName("api")
    String api;

    String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void setFakeImage(List<AndroidDTO> list) {
        for (AndroidDTO dto : list) {
            dto.setUrl("http://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg");
        }
    }
}
