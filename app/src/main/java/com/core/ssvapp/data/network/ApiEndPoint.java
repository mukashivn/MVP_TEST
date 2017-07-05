package com.core.ssvapp.data.network;

/**
 * Created by CuongCK on 2/13/17.
 */

public final class ApiEndPoint {
    //Decleare the api endpoint
    //Test API
    public static final String ENDPOINT_LOGIN = "/android/jsonarray/";

    //Token
    public static final String ENDPOINT_GET_ACCESS_TOKEN = "/oauth2/token";
    //Search
    public static final String ENDPOINT_SEARCH = "/v3/businesses/search?";
    //Review
    public static final String ENDPOINT_GET_REVIEW = "/v3/businesses/{id}/reviews";
    //Businees Detail
    public static final String ENDPOINT_GET_BUSINESS_DETAIL = "/v3/businesses/{id}";
}
