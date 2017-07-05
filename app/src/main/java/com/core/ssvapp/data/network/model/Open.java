package com.core.ssvapp.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Package: com.core.ssvapp.data.network.model
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class Open {
    @SerializedName("is_overnight")

    private Boolean isOvernight;
    @SerializedName("start")

    private String start;
    @SerializedName("end")

    private String end;
    @SerializedName("day")

    private Integer day;

    public Boolean getIsOvernight() {
        return isOvernight;
    }

    public void setIsOvernight(Boolean isOvernight) {
        this.isOvernight = isOvernight;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

}
