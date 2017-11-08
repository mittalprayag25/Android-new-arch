package com.prayag.arch.application.injection.components;

import android.arch.lifecycle.ViewModel;

import com.prayag.arch.application.injection.modules.AppViewModelModule;
import com.prayag.arch.sla.viewmodel.StarshipsViewModel;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@Component(modules = AppViewModelModule.class)
public interface AppViewModelComponent {
    void inject(ViewModel slaViewModel);
    void inject(StarshipsViewModel starshipsViewModel);
}
