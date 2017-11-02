package com.prayag.arch.application.injection.components;

import com.prayag.arch.application.injection.modules.AppViewModelModule;
import com.prayag.arch.sla.viewmodel.SlaViewModel;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@Component(modules = AppViewModelModule.class)
public interface AppViewModelComponent {
    void inject(SlaViewModel slaViewModel);
}
