package com.prayag.arch.sla.injection.modules;

import android.app.Activity;

import com.prayag.arch.sla.dao.Starship;

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


}
