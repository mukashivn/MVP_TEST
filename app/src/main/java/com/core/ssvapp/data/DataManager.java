package com.core.ssvapp.data;

import com.core.ssvapp.data.network.ApiHelper;
import com.core.ssvapp.data.network.model.Android;
import com.core.ssvapp.data.network.model.LoginRequest;
import com.core.ssvapp.data.network.response.AccessTokenResponse;
import com.core.ssvapp.data.network.response.BusinessDetailResponse;
import com.core.ssvapp.data.network.response.ReviewResponse;
import com.core.ssvapp.data.network.response.SearchResponse;
import com.core.ssvapp.data.prefs.PreferencesHelper;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by CuongCK on 2/13/17.
 */

public interface DataManager extends PreferencesHelper, ApiHelper {
    Observable<List<Android>> login(LoginRequest loginRequest);

    Observable<AccessTokenResponse> dmetAccessToken();

    Observable<SearchResponse> dmGetSearch(String term, double latitude, double longtitude);

    Observable<ReviewResponse> dmGetReviews(String id);

    Observable<BusinessDetailResponse> dmGetBusinessDetail(String id);
}
