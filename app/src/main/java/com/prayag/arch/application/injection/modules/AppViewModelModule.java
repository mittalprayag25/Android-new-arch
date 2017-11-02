package com.prayag.arch.application.injection.modules;

import android.app.Application;

import com.prayag.arch.sla.dao.TestGag;
import com.prayag.arch.application.room.AppDatabase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 31/10/17.
 */

@Module
public class AppViewModelModule {

    Application application;
    public AppViewModelModule(Application application){
        this.application = application;
    }

    @Provides
    TestGag provideTest(){
        return new TestGag();
    }

    @Provides
    AppDatabase provideDbAccess(){
        return AppDatabase.getInstance(application);
    }

}
