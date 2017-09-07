package za.co.riggaroo.datecountdown.mmvm.dagger2Impl;

import android.app.Activity;

import dagger.Component;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.dependencies.Person;

/**
 * Created by pmittal on 28/08/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity activity);

   // Person getPerson();
}
