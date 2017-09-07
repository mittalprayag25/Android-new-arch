package com.prayag.arch.application;


import android.app.Application;
import android.content.Context;

import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.application.injection.ApplicationModule;
import com.prayag.arch.application.injection.CountdownComponent;
import com.prayag.arch.application.injection.CountdownModule;
import com.prayag.arch.application.injection.DaggerApplicationComponent;
import com.prayag.arch.application.injection.DaggerCountdownComponent;
import com.prayag.arch.application.data.DataManager;

import javax.inject.Inject;

public class CountdownApplication extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();
    protected CountdownComponent createCountdownComponent() {
        return DaggerCountdownComponent.builder()
                .countdownModule(new CountdownModule(this))
                .build();
    }

    public CountdownComponent getCountDownComponent() {
        return countDownComponent;
    }

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static CountdownApplication get(Context context) {
        return (CountdownApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
/*********************************************************************/

//
//    private final CountdownComponent countDownComponent = createCountdownComponent();
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        AndroidThreeTen.init(this);
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());//TODO Install a Crashlytics tree in production
//        }
//    }
//
//    protected CountdownComponent createCountdownComponent() {
//        return DaggerCountdownComponent.builder()
//                .countdownModule(new CountdownModule(this))
//                .build();
//    }
//
//    public CountdownComponent getCountDownComponent() {
//        return countDownComponent;
//    }

    /*****************************************************/
}

