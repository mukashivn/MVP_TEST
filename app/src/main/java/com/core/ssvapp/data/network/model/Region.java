package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Region {
    @SerializedName("center")
    private Center center;

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
