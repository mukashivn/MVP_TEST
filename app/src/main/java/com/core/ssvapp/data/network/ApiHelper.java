package com.core.ssvapp.data.network;

import com.core.ssvapp.data.network.model.Android;
import com.core.ssvapp.data.network.response.AccessTokenResponse;
import com.core.ssvapp.data.network.response.BusinessDetailResponse;
import com.core.ssvapp.data.network.response.ReviewResponse;
import com.core.ssvapp.data.network.response.SearchResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CuongCK on 2/13/17.
 */
//Decleare all interface here
public interface ApiHelper {
    //For example
    @GET(ApiEndPoint.ENDPOINT_LOGIN)
    Observable<List<Android>> login();

    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(ApiEndPoint.ENDPOINT_GET_ACCESS_TOKEN)
    Observable<AccessTokenResponse> getAccessToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("grant_type") String grantType);

    @GET(ApiEndPoint.ENDPOINT_SEARCH)
    Observable<SearchResponse> search(@Header("Authorization") String bearer, @Query("term") String term, @Query("latitude") double latitude, @Query("longitude") double longitude);

    @GET(ApiEndPoint.ENDPOINT_GET_REVIEW)
    Observable<ReviewResponse> getReviews(@Header("Authorization") String bearer,@Path("id") String reviewId);

    @GET(ApiEndPoint.ENDPOINT_GET_BUSINESS_DETAIL)
    Observable<BusinessDetailResponse> getBusinessDetail(@Header("Authorization") String bearer,@Path("id") String busineesId);
}
