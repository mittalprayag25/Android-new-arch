package com.prayag.arch.daggerexample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.daggerexample.dao.TechStack;
import com.prayag.arch.daggerexample.injection.components.ActivityComponent;
import com.prayag.arch.daggerexample.injection.components.DaggerActivityComponent;
import com.prayag.arch.daggerexample.injection.modules.ActivityModule;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.daggerexample.dao.User;

/**
 * Created by pmittal on 28/08/17.
 */

public class DaggerActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;
//
    @Inject
    TechStack techStack;


    private ActivityComponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(CountdownApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);

        Log.d("AGE",String.valueOf(techStack.getTech()));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}