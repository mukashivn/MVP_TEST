package com.core.ssvapp.data.network.response;

import com.core.ssvapp.data.network.model.Review;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Package: com.core.ssvapp.data.network.response
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class ReviewResponse {
    @SerializedName("reviews")

    private List<Review> reviews = null;
    @SerializedName("total")
 
    private Integer total;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
