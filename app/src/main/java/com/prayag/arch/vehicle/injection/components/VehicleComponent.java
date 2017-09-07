package com.prayag.arch.vehicle.injection.components;

import com.prayag.arch.vehicle.injection.modules.VehicleModule;
import com.prayag.arch.vehicle.dao.Vehicle;

import dagger.Component;

/**
 * Created by pmittal on 21/08/17.
 */

@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();
}
