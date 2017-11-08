package com.prayag.arch.sla.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.prayag.arch.application.util.diQualifier.ActivityContext;
import com.prayag.arch.sla.dao.Starships;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 31/10/17.
 */

@Module
public class SlaModule {

    Activity mActivity;
    public SlaModule(Activity mActivity){
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
    Starships getStarships(){
        return new Starships();
    }
}
