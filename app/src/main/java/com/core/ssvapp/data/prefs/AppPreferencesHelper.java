package com.core.ssvapp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.core.ssvapp.di.ApplicationContext;
import com.core.ssvapp.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by CuongCK on 2/13/17.
 */
@Singleton
public class AppPreferencesHelper implements PreferencesHelper {
    private final SharedPreferences mPrefs;
    private final static String PREF_KEY_ACCESS_TOKEN = "Access_Token";

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String prefGetAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "");
    }

    @Override
    public void prefSaveAccessToken(String token) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, token).commit();
    }
}
