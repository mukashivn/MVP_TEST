package com.core.ssvapp.ui.businessdetail;

import com.core.ssvapp.data.DataManager;
import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Package: com.core.ssvapp.ui.businessdetail
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class DetailPresenter<V extends IDetailView> extends BasePresenter<V> implements IDetailPresenter<V> {
    @Inject
    public DetailPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void init(Business business) {
        getMvpView().showName(business.getName());
        getMvpView().showImage(business.getImageUrl());
        getMvpView().showPhone(business.getPhone());
        getMvpView().showWeb(business.getUrl());
        getMvpView().showCategory(business.getCategories());
        getMvpView().showAddress(business.getLocation().getAddress1());
    }
}
