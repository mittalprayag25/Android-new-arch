package com.prayag.arch.application.injection.modules;

import android.app.Application;

import com.prayag.arch.sla.dao.Starship;
import com.prayag.arch.application.room.AppDatabase;
import com.prayag.arch.sla.dao.Starships;

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
    Starships provideStarship(){
        return new Starships();
    }

    @Provides
    AppDatabase provideDbAccess(){
        return AppDatabase.getInstance(application);
    }

}
