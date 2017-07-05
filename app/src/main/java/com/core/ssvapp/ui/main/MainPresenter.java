package com.core.ssvapp.ui.main;

import com.core.ssvapp.data.DataManager;
import com.core.ssvapp.ui.base.BaseActivity;
import com.core.ssvapp.ui.base.BasePresenter;
import com.core.ssvapp.utils.CommonUtils;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Package: com.core.ssvapp.ui.main
 * Created by: CuongCK
 * Date: 4/3/17
 */

public class MainPresenter<V extends IMainView> extends BasePresenter<V> implements IMainPresenter<V> {
    private Timer timer;
    private int recorderSecondsElapsed;

    private final static int STOP = 0;
    private final static int RECORDING = 1;
    private final static int PAUSE = 2;

    private int mRecordState = -STOP;

    @Inject
    MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void openSettingScreen(BaseActivity activity) {

    }

    @Override
    public void handleRecordAction(BaseActivity activity) {
        switch (mRecordState) {
            case STOP:
                startRecord(activity);
                break;
            case RECORDING:
                pauseRecord(activity);
                break;
            case PAUSE:
                resumeRecord(activity);
                break;
        }
    }

    @Override
    public void handleRecordListAction(BaseActivity activity) {
        switch (mRecordState) {
            case STOP:
                openSettingScreen(activity);
                break;
            case RECORDING:
                stopRecord(activity);
                break;
            case PAUSE:
                stopRecord(activity);
                break;
        }
    }

    @Override
    public void updateTimer(BaseActivity activity) {
        activity.runOnUiThread(() -> {
            if (mRecordState == RECORDING) {
                recorderSecondsElapsed++;
                getMvpView().onRecordTimeTextChange(CommonUtils.formatSeconds(recorderSecondsElapsed));
            }
        });
    }

    @Override
    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    @Override
    public void startTimer(BaseActivity activity) {
        stopTimer();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTimer(activity);
            }
        }, 0, 1000);
    }

    @Override
    public void startRecord(BaseActivity activity) {
        mRecordState = RECORDING;
        stopTimer();
        recorderSecondsElapsed = 0;
        getMvpView().onRecordActionShowPause();
        getMvpView().onRecordListShowStop();
        startTimer(activity);
        //Start record here
    }

    @Override
    public void pauseRecord(BaseActivity activity) {
        mRecordState = PAUSE;
        stopTimer();
        getMvpView().onRecordActionShowDefault();
        //Pause record here
    }

    @Override
    public void resumeRecord(BaseActivity activity) {
        mRecordState = RECORDING;
        startTimer(activity);
        getMvpView().onRecordActionShowPause();
        //Resume record here

    }

    @Override
    public void stopRecord(BaseActivity activity) {
        mRecordState = STOP;
        stopTimer();
        recorderSecondsElapsed = 0;
        getMvpView().onRecordActionShowDefault();
        getMvpView().onRecordListShowDefault();
        //stop record

    }

    @Override
    public void openRecordListOrStop(BaseActivity activity) {

    }
}
