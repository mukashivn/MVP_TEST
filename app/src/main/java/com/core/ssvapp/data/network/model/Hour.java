package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Hour {
    @SerializedName("open")
    private List<Open> open = null;
    @SerializedName("hours_type")
    private String hoursType;
    @SerializedName("is_open_now")
    private Boolean isOpenNow;

    public List<Open> getOpen() {
        return open;
    }

    public void setOpen(List<Open> open) {
        this.open = open;
    }

    public String getHoursType() {
        return hoursType;
    }

    public void setHoursType(String hoursType) {
        this.hoursType = hoursType;
    }

    public Boolean getIsOpenNow() {
        return isOpenNow;
    }

    public void setIsOpenNow(Boolean isOpenNow) {
        this.isOpenNow = isOpenNow;
    }
}
