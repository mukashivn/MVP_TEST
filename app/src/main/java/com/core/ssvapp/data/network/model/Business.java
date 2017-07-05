package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Business implements Serializable {
    @SerializedName("id")

    private String id;
    @SerializedName("name")

    private String name;
    @SerializedName("image_url")

    private String imageUrl;
    @SerializedName("is_closed")

    private Boolean isClosed;
    @SerializedName("url")

    private String url;
    @SerializedName("review_count")

    private int reviewCount;
    @SerializedName("categories")

    private List<Category> categories = null;
    @SerializedName("rating")

    private double rating;
    @SerializedName("coordinates")

    private Coordinates coordinates;
    @SerializedName("transactions")

    private List<String> transactions = null;
    @SerializedName("price")

    private String price;
    @SerializedName("location")

    private Location location;
    @SerializedName("phone")

    private String phone;
    @SerializedName("display_phone")

    private String displayPhone;
    @SerializedName("distance")

    private Double distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
