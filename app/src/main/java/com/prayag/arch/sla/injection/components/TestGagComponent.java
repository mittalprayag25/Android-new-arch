package com.prayag.arch.sla.injection.components;

import com.prayag.arch.application.injection.ApplicationComponent;
import com.prayag.arch.sla.injection.modules.SlaModule;
import com.prayag.arch.sla.injection.modules.TestGagModule;
import com.prayag.arch.sla.ui.SlaFragment;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@Component(modules = TestGagModule.class)
public interface TestGagComponent {
    void inject(SlaFragment fragment);
}
