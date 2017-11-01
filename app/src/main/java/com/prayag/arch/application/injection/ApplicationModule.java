package com.prayag.arch.application.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.prayag.arch.application.util.diQualifier.ApplicationContext;
import com.prayag.arch.application.util.diQualifier.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 28/08/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
