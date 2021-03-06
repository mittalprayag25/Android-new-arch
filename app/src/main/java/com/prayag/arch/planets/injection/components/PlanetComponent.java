package com.prayag.arch.planets.injection.components;

import android.app.Activity;

import com.prayag.arch.application.injection.components.ApplicationComponent;
import com.prayag.arch.application.util.diQualifier.PerActivity;
import com.prayag.arch.planets.injection.modules.PlanetModule;
import com.prayag.arch.planets.ui.PlanetActivity;
import com.prayag.arch.planets.ui.PlanetDetailActivity;

import dagger.Component;

/**
 * Created by pmittal on 31/10/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = PlanetModule.class)
public interface PlanetComponent {
    void inject(PlanetActivity activity);
    void inject(PlanetDetailActivity activity);
}
