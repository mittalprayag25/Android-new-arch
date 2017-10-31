package com.prayag.arch.user.injection.components;

import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.user.ui.DaggerActivity;
import com.prayag.arch.user.injection.modules.UserModule;
import com.prayag.arch.application.util.diQualifier.PerActivity;

import dagger.Component;

/**
 * Created by pmittal on 28/08/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = UserModule.class)
public interface UserComponent {
    void inject(DaggerActivity activity);
}
