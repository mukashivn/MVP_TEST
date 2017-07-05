package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class User {
    @SerializedName("image_url")

    private String imageUrl;
    @SerializedName("name")

    private String name;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
