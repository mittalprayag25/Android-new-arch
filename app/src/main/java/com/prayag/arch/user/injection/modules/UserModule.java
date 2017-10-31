package com.prayag.arch.user.injection.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import com.prayag.arch.user.dao.TechStack;
import com.prayag.arch.application.util.diQualifier.ActivityContext;

/**
 * Created by pmittal on 28/08/17.
 */

@Module
public class UserModule {

    Activity mActivity;

    public UserModule(Activity activity){
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
    TechStack getPerson(){
        return new TechStack();
    }
}
