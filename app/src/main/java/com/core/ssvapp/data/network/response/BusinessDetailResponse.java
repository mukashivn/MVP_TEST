package com.core.ssvapp.data.network.response;

import com.core.ssvapp.data.network.model.Category;
import com.core.ssvapp.data.network.model.Coordinates;
import com.core.ssvapp.data.network.model.Hour;
import com.core.ssvapp.data.network.model.Location;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Package: com.core.ssvapp.data.network.response
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class BusinessDetailResponse {
    @SerializedName("id")

    private String id;
    @SerializedName("name")

    private String name;
    @SerializedName("image_url")

    private String imageUrl;
    @SerializedName("is_claimed")

    private Boolean isClaimed;
    @SerializedName("is_closed")

    private Boolean isClosed;
    @SerializedName("url")

    private String url;
    @SerializedName("phone")

    private String phone;
    @SerializedName("display_phone")

    private String displayPhone;
    @SerializedName("review_count")

    private Integer reviewCount;
    @SerializedName("categories")

    private List<Category> categories = null;
    @SerializedName("rating")

    private Integer rating;
    @SerializedName("location")

    private Location location;
    @SerializedName("coordinates")

    private Coordinates coordinates;
    @SerializedName("photos")

    private List<String> photos = null;
    @SerializedName("price")

    private String price;
    @SerializedName("hours")

    private List<Hour> hours = null;
    @SerializedName("transactions")

    private List<String> transactions = null;

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

    public Boolean getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

}
