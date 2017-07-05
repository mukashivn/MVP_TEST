package com.core.ssvapp.ui.main;

import com.core.ssvapp.di.PerActivity;
import com.core.ssvapp.ui.base.BaseActivity;
import com.core.ssvapp.ui.base.IPresenter;

/**
 * Package: com.core.ssvapp.ui.main
 * Created by: CuongCK
 * Date: 4/3/17
 */
@PerActivity
public interface IMainPresenter<V extends IMainView> extends IPresenter<V> {
    void openSettingScreen(BaseActivity activity);

    void handleRecordAction(BaseActivity activity);

    void handleRecordListAction(BaseActivity activity);

    void updateTimer(BaseActivity activity);

    void stopTimer();

    void startTimer(BaseActivity activity);

    void startRecord(BaseActivity activity);

    void pauseRecord(BaseActivity activity);

    void resumeRecord(BaseActivity activity);

    void stopRecord(BaseActivity activity);

    void openRecordListOrStop(BaseActivity activity);
}
