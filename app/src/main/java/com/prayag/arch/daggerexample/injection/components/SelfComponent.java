package com.prayag.arch.daggerexample.injection.components;

import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.company.dao.Company;
import com.prayag.arch.company.ui.DaggerSelfActivity;
import com.prayag.arch.daggerexample.injection.modules.SelfModule;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.application.diQualifier.PerActivity;

import dagger.Component;

/**
 * Created by pmittal on 05/09/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class ,modules = SelfModule.class)
public interface SelfComponent {

    Company provideCompany();

    void inject(DaggerSelfActivity activity);

    DataManager getDataManager();
}
