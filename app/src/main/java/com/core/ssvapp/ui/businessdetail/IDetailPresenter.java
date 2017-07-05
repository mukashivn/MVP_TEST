package com.core.ssvapp.ui.businessdetail;

import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.di.PerActivity;
import com.core.ssvapp.ui.base.IPresenter;

/**
 * Package: com.core.ssvapp.ui.businessdetail
 * Created by: CuongCK
 * Date: 7/5/17
 */
@PerActivity
public interface IDetailPresenter<V extends IDetailView> extends IPresenter<V> {
    void init(Business business);
}
