package com.core.ssvapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.core.ssvapp.R;
import com.core.ssvapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.record_pause_list)
    TextView mRecordPauseList;
    @BindView(R.id.record_state)
    TextView mRecordState;
    @BindView(R.id.count_down_timer)
    TextView mCountDownTime;
    @BindView(R.id.action_record)
    ImageButton actionRecord;
    @BindView(R.id.record_list)
    ImageButton recordList;

    @Inject
    IMainPresenter<IMainView> mPresenter;

    public static Intent startIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.action_setting)
    void openSettingScreen() {
        mPresenter.openSettingScreen(this);
    }

    @OnClick(R.id.action_record)
    void actionRecord() {
        mPresenter.handleRecordAction(this);
    }

    @OnClick(R.id.record_list)
    void actionRecordList() {
        mPresenter.handleRecordListAction(this);
    }

    @Override
    public void onRecordTimeTextChange(String time) {
        mCountDownTime.setText(time);
    }

    @Override
    public void onRecordActionShowPause() {
        mRecordState.setText(getString(R.string.pause_action));
        actionRecord.setImageResource(R.drawable.ic_pause);
    }

    @Override
    public void onRecordActionShowDefault() {
        mRecordState.setText(getString(R.string.record_action));
        actionRecord.setImageResource(R.drawable.ic_record_stype_2);
    }

    @Override
    public void onRecordListShowStop() {
        mRecordPauseList.setText(getString(R.string.stop_action));
        recordList.setImageResource(R.drawable.ic_stop);
    }

    @Override
    public void onRecordListShowDefault() {
        mRecordPauseList.setText(getString(R.string.record_list));
        recordList.setImageResource(R.drawable.ic_menu);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
