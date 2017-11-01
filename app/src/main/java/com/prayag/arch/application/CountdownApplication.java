package com.prayag.arch.application;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.application.injection.ApplicationModule;
import com.prayag.arch.application.injection.DaggerApplicationComponent;
import com.prayag.arch.user.dao.User;

import javax.inject.Inject;

public class CountdownApplication extends Application {

    protected ApplicationComponent applicationComponent;

    // To explain dagger DataManager can be injected here and used
    @Inject
    DataManager mDataManager;

    public static CountdownApplication get(Context context) {
        return (CountdownApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        /*************** This is valid and can be used ************/
       /* try {
            User user = mDataManager.getUser(1L);
            Log.d("USER", user.toString());
        }catch (Exception e){e.printStackTrace();}
        */
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

}

