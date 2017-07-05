package com.core.ssvapp.ui.main;

import com.core.ssvapp.ui.base.IView;

/**
 * Package: com.core.ssvapp.ui.main
 * Created by: CuongCK
 * Date: 4/3/17
 */

public interface IMainView extends IView {
    void onRecordTimeTextChange(String time);
    void onRecordActionShowPause();
    void onRecordActionShowDefault();
    void onRecordListShowStop();
    void onRecordListShowDefault();
}
