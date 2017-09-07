package com.prayag.arch.daggerexample.injection.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import com.prayag.arch.daggerexample.dao.Person;
import com.prayag.arch.application.diQualifier.ActivityContext;

/**
 * Created by pmittal on 28/08/17.
 */

@Module
public class ActivityModule {

    Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    Person getPerson(){
        return new Person();
    }
}
