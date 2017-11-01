package com.prayag.arch.sla.injection.modules;

import android.app.Activity;

import com.prayag.arch.application.api.TestGag;
import com.prayag.arch.application.data.DataManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 31/10/17.
 */

@Module
public class TestGagModule {

    Activity mActivity;
    public TestGagModule(Activity mActivity){
        this.mActivity = mActivity;
    }


    @Provides
    TestGag provideTest(){
        return new TestGag();
    }

}
