package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Review {
    @SerializedName("url")

    private String url;
    @SerializedName("text")

    private String text;
    @SerializedName("rating")

    private Integer rating;
    @SerializedName("user")

    private User user;
    @SerializedName("time_created")

    private String timeCreated;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
