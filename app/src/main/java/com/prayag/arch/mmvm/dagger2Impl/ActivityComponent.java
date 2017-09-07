package com.prayag.arch.mmvm.dagger2Impl;

import dagger.Component;

/**
 * Created by pmittal on 28/08/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity activity);

   // Person getPerson();
}
