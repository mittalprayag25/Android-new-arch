package com.prayag.arch.planets.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.prayag.arch.application.util.diQualifier.ActivityContext;
import com.prayag.arch.planets.dao.Planets;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 31/10/17.
 */

@Module
public class PlanetModule {

    Activity mActivity;
    public PlanetModule(Activity mActivity){
        this.mActivity = mActivity;
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
    Planets getCitizenAlerts(){
        return new Planets();
    }
}
