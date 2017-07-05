package com.core.ssvapp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.core.ssvapp.di.component.ApplicationComponent;
import com.core.ssvapp.di.component.DaggerApplicationComponent;
import com.core.ssvapp.di.module.ApplicationModule;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by CuongCK on 2/13/17.
 */

public class ApplicationImpl extends Application {
    @Inject
    CalligraphyConfig mCalligraphyConfig;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
