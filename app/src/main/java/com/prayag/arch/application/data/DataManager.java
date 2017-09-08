package com.prayag.arch.application.data;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.prayag.arch.application.diQualifier.ApplicationContext;
import com.prayag.arch.daggerexample.dao.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }
    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        Log.d("AccessToken", "token receiveedf");
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        Log.d("AccessToken", "token receiveedf");
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}