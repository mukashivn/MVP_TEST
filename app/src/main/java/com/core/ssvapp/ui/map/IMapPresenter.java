package com.core.ssvapp.ui.map;

import android.os.Handler;

import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.di.PerActivity;
import com.core.ssvapp.ui.base.IPresenter;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Package: com.core.ssvapp.ui.map
 * Created by: CuongCK
 * Date: 7/5/17
 */
@PerActivity
public interface IMapPresenter<V extends IMapViews> extends IPresenter<V> {
    void init();

    void getRes(double latitide, double longtitude);

    MarkerOptions createMarker(Business business);

    void onCameraMove(Handler handler);
}
