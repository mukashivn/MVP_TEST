package com.core.ssvapp.di.module;

import android.app.Activity;
import android.content.Context;

import com.core.ssvapp.di.ActivityContext;
import com.core.ssvapp.di.PerActivity;
import com.core.ssvapp.ui.businessdetail.DetailPresenter;
import com.core.ssvapp.ui.businessdetail.IDetailPresenter;
import com.core.ssvapp.ui.businessdetail.IDetailView;
import com.core.ssvapp.ui.main.IMainPresenter;
import com.core.ssvapp.ui.main.IMainView;
import com.core.ssvapp.ui.main.MainPresenter;
import com.core.ssvapp.ui.map.IMapPresenter;
import com.core.ssvapp.ui.map.IMapViews;
import com.core.ssvapp.ui.map.MapPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by CuongCK on 2/13/17.
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @PerActivity
    @Provides
    IMainPresenter<IMainView> provideMainPresenter(MainPresenter<IMainView> mainPresenter) {
        return mainPresenter;
    }

    @PerActivity
    @Provides
    IMapPresenter<IMapViews> provideMapPresenter(MapPresenter<IMapViews> mapPresenter) {
        return mapPresenter;
    }

    @PerActivity
    @Provides
    IDetailPresenter<IDetailView> providerDetailPresenter(DetailPresenter<IDetailView> detailPresenter) {
        return detailPresenter;
    }

}
