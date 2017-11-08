package com.prayag.arch.application.data;

import android.content.Context;
import android.util.Log;

import com.prayag.arch.application.util.diQualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mSharedPrefsHelper = sharedPrefsHelper;
    }
    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        Log.d("AccessToken", "token receiveedf");
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

}