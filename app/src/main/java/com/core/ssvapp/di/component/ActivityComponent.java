package com.core.ssvapp.di.component;

import com.core.ssvapp.di.PerActivity;
import com.core.ssvapp.di.module.ActivityModule;
import com.core.ssvapp.ui.businessdetail.DetailAcitivty;
import com.core.ssvapp.ui.main.MainActivity;
import com.core.ssvapp.ui.map.MapActivity;

import dagger.Component;

/**
 * Created by CuongCK on 2/13/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(MapActivity mapActivity);

    void inject(DetailAcitivty detailAcitivty);
}
