package com.core.ssvapp.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by CuongCK on 2/13/17.
 */

public interface IView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
