package com.prayag.arch.sla.injection.components;

import com.prayag.arch.sla.injection.modules.SlaViewModelModule;
import com.prayag.arch.sla.injection.modules.TestGagModule;
import com.prayag.arch.sla.ui.SlaFragment;
import com.prayag.arch.sla.viewmodel.SlaViewModel;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@Component(modules = SlaViewModelModule.class)
public interface SlaViewModelComponent {
    void inject(SlaViewModel slaViewModel);
}
