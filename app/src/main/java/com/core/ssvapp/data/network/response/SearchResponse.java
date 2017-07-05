package com.core.ssvapp.data.network.response;

import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.data.network.model.Region;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Package: com.core.ssvapp.data.network.response
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class SearchResponse {
    @SerializedName("businesses")
    private List<Business> businesses = null;
    @SerializedName("total")

    private Integer total;
    @SerializedName("region")

    private Region region;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
