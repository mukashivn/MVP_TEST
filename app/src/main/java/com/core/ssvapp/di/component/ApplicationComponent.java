package com.core.ssvapp.di.component;

import android.app.Application;
import android.content.Context;

import com.core.ssvapp.ApplicationImpl;
import com.core.ssvapp.data.DataManager;
import com.core.ssvapp.di.ApplicationContext;
import com.core.ssvapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by CuongCK on 2/13/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ApplicationImpl app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
