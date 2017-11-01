package com.prayag.arch.sla.injection.modules;

import android.app.Activity;

import com.prayag.arch.application.api.TestGag;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 31/10/17.
 */

@Module
public class SlaViewModelModule {

    Activity mActivity;
    public SlaViewModelModule(){

    }


    @Provides
    TestGag provideTest(){
        return new TestGag();
    }

}
