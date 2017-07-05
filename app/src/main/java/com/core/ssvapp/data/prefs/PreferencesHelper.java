package com.core.ssvapp.data.prefs;

/**
 * Created by CuongCK on 2/13/17.
 */

public interface PreferencesHelper {
    //Define all method here
    String prefGetAccessToken();

    void prefSaveAccessToken(String token);
}
