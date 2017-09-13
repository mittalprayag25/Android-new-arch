package com.prayag.arch.daggerexample.injection.components;

import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.daggerexample.ui.DaggerActivity;
import com.prayag.arch.daggerexample.injection.modules.ActivityModule;
import com.prayag.arch.application.diQualifier.PerActivity;

import dagger.Component;

/**
 * Created by pmittal on 28/08/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity activity);

   // TechStack getPerson();
}
