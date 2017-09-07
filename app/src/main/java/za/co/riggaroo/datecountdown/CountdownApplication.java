package za.co.riggaroo.datecountdown;


import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import za.co.riggaroo.datecountdown.injection.CountdownComponent;
import za.co.riggaroo.datecountdown.injection.CountdownModule;
import za.co.riggaroo.datecountdown.injection.DaggerCountdownComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.ApplicationComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.ApplicationModule;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DaggerApplicationComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DataManager;

public class CountdownApplication extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        AndroidThreeTen.init(this);
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());//TODO Install a Crashlytics tree in production
//        }
//    }

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
}

