package za.co.riggaroo.datecountdown.mmvm.dagger2Impl;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import za.co.riggaroo.datecountdown.CountdownApplication;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.dependencies.Person;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(CountdownApplication daggerApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();



}
