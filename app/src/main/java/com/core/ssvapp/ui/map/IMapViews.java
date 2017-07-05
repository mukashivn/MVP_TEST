package com.core.ssvapp.ui.map;

import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.ui.base.IView;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Package: com.core.ssvapp.ui.map
 * Created by: CuongCK
 * Date: 7/5/17
 */

public interface IMapViews extends IView {
    void showGetAccessToken();

    void showCommonMessage(int id);

    void showRestaurants(List<Business> list);

    void updateBoundCamera();
}
