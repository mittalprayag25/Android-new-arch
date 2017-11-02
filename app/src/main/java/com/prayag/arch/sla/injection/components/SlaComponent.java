package com.prayag.arch.sla.injection.components;

import com.prayag.arch.application.injection.components.ApplicationComponent;
import com.prayag.arch.application.util.diQualifier.PerActivity;
import com.prayag.arch.sla.injection.modules.SlaModule;
import com.prayag.arch.sla.ui.SlaActivity;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = SlaModule.class)
public interface SlaComponent {
    void inject(SlaActivity activity);
}
