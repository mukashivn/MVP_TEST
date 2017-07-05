package com.core.ssvapp.data;

import android.content.Context;

import com.core.ssvapp.BuildConfig;
import com.core.ssvapp.data.network.ApiHelper;
import com.core.ssvapp.data.network.model.Android;
import com.core.ssvapp.data.network.model.LoginRequest;
import com.core.ssvapp.data.network.response.AccessTokenResponse;
import com.core.ssvapp.data.network.response.BusinessDetailResponse;
import com.core.ssvapp.data.network.response.ReviewResponse;
import com.core.ssvapp.data.network.response.SearchResponse;
import com.core.ssvapp.data.prefs.PreferencesHelper;
import com.core.ssvapp.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CuongCK on 2/13/17.
 */
@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";


    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context mContext, PreferencesHelper mPreferencesHelper, ApiHelper mApiHelper) {
        this.mContext = mContext;
        this.mPreferencesHelper = mPreferencesHelper;
        this.mApiHelper = mApiHelper;
    }


    @Override
    public Observable<List<Android>> login() {
        return mApiHelper.login();
    }

    @Override
    public Observable<AccessTokenResponse> getAccessToken(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("grant_type") String grantType) {
        return mApiHelper.getAccessToken(clientId, clientSecret, grantType);
    }

    @Override
    public Observable<SearchResponse> search(@Header("Authorization") String bearer, @Query("term") String term, @Query("latitude") double latitude, @Query("longitude") double longitude) {
        return mApiHelper.search(bearer, term, latitude, longitude);
    }

    @Override
    public Observable<ReviewResponse> getReviews(@Header("Authorization") String bearer, @Path("id") String reviewId) {
        return mApiHelper.getReviews(bearer, reviewId);
    }

    @Override
    public Observable<BusinessDetailResponse> getBusinessDetail(@Header("Authorization") String bearer, @Path("id") String busineesId) {
        return mApiHelper.getBusinessDetail(bearer, busineesId);
    }

    @Override
    public Observable<List<Android>> login(LoginRequest loginRequest) {
        return login()
                .flatMap(new Function<List<Android>, ObservableSource<List<Android>>>() {
                    @Override
                    public ObservableSource<List<Android>> apply(List<Android> androids) throws Exception {
                        return Observable.just(androids);
                    }
                })
                .map(new Function<List<Android>, List<Android>>() {
                    @Override
                    public List<Android> apply(List<Android> o) throws Exception {
                        return o;
                    }
                })
                ;
    }

    @Override
    public Observable<AccessTokenResponse> dmetAccessToken() {
        return getAccessToken(BuildConfig.YELP_CLIENT_ID, BuildConfig.YELP_CLIENT_SECRET, BuildConfig.YELP_GRANT_TYPE);
    }

    @Override
    public Observable<SearchResponse> dmGetSearch(String term, double latitude, double longtitude) {
        return search("Bearer " + mPreferencesHelper.prefGetAccessToken(), term, latitude, longtitude);
    }

    @Override
    public Observable<ReviewResponse> dmGetReviews(String id) {
        return getReviews("Bearer " + mPreferencesHelper.prefGetAccessToken(), id);
    }

    @Override
    public Observable<BusinessDetailResponse> dmGetBusinessDetail(String id) {
        return getBusinessDetail("Bearer " + mPreferencesHelper.prefGetAccessToken(), id);
    }

    @Override
    public String prefGetAccessToken() {
        return mPreferencesHelper.prefGetAccessToken();
    }

    @Override
    public void prefSaveAccessToken(String token) {
        mPreferencesHelper.prefSaveAccessToken(token);
    }
}
