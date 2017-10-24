package com.prayag.arch.application.injection;

import android.app.Application;
import android.content.Context;

import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.application.diQualifier.ApplicationContext;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.application.data.DbHelper;
import com.prayag.arch.application.data.SharedPrefsHelper;
import com.prayag.arch.event.viewmodel.AddEventViewModel;
import com.prayag.arch.event.viewmodel.EventListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, CountdownModule.class})
public interface ApplicationComponent {

    void inject(CountdownApplication daggerApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }

}
