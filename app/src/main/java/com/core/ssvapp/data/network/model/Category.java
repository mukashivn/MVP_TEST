package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Category implements Serializable{
    @SerializedName("alias")
    private String alias;
    @SerializedName("title")
    private String title;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
