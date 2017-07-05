package com.core.ssvapp.ui.map;

import android.os.Handler;

import com.core.ssvapp.R;
import com.core.ssvapp.data.DataManager;
import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.data.network.response.AccessTokenResponse;
import com.core.ssvapp.data.network.response.SearchResponse;
import com.core.ssvapp.ui.base.BasePresenter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Package: com.core.ssvapp.ui.map
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class MapPresenter<V extends IMapViews> extends BasePresenter<V> implements IMapPresenter<V> {
    private boolean isFirstTime = true;
    private static final int MESSAGE_ID_SAVE_CAMERA_POSITION = 1;
    private static final int MESSAGE_ID_READ_CAMERA_POSITION = 2;

    @Inject
    MapPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    /**
     * Get access token
     */
    @Override
    public void init() {
        getCompositeDisposable()
                .add(getDataManager()
                        .dmetAccessToken()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> getMvpView().showLoading())
                        .doOnComplete(() -> getMvpView().hideLoading())
                        .doOnError(throwable -> getMvpView().hideLoading())
                        .subscribe(this::handleGetAccessTokenSuccess, this::handleFail));
    }

    private void handleGetAccessTokenSuccess(AccessTokenResponse response) {
        getDataManager().prefSaveAccessToken(response.getAccessToken());
        getMvpView().showGetAccessToken();
    }


    /*
    * Get list restaurant by latitude and longtitude
    * You can change Term
    * */
    @Override
    public void getRes(double latitide, double longtitude) {
        getCompositeDisposable()
                .add(getDataManager()
                        .dmGetSearch("restaurants", latitide, longtitude)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> {
                        })
                        .doOnComplete(() -> {
                        })
                        .doOnError(throwable -> {
                        })
                        .subscribe(this::handleGetResSuccess, this::handleFail));
    }

    private void handleGetResSuccess(SearchResponse response) {
        //Show Restaurant with maker here
        getMvpView().showRestaurants(response.getBusinesses());
        if (isFirstTime) {
            getMvpView().updateBoundCamera();
            isFirstTime = false;
        }
    }

    private void handleGetResFail(Throwable throwable) {
    }

    /**
     * Common
     */
    private void handleFail(Throwable throwable) {
        getMvpView().showCommonMessage(R.string.error);
    }

    @Override
    public MarkerOptions createMarker(Business business) {
        Gson gson = new Gson();
        String snip = gson.toJson(business);
        LatLng resturant = new LatLng(business.getCoordinates().getLatitude(), business.getCoordinates().getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(resturant).title(business.getName()).snippet(snip);
        return markerOptions;
    }

    @Override
    public void onCameraMove(Handler handler) {
        handler.removeMessages(MESSAGE_ID_SAVE_CAMERA_POSITION);
        handler.removeMessages(MESSAGE_ID_READ_CAMERA_POSITION);
        handler.sendEmptyMessageDelayed(MESSAGE_ID_SAVE_CAMERA_POSITION, 500);
        handler.sendEmptyMessageDelayed(MESSAGE_ID_READ_CAMERA_POSITION, 1000);

    }

}
