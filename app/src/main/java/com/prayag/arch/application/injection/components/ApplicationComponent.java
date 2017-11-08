package com.prayag.arch.application.injection.components;

import android.app.Application;
import android.content.Context;

import com.prayag.arch.application.UniverseApplication;
import com.prayag.arch.application.injection.modules.ApplicationModule;
import com.prayag.arch.application.util.diQualifier.ApplicationContext;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.application.data.SharedPrefsHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(UniverseApplication daggerApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();


}
