package com.prayag.arch.vehicle.injection.modules;

import com.prayag.arch.vehicle.dao.Motor;
import com.prayag.arch.vehicle.dao.Vehicle;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pmittal on 21/08/17.
 */

@Module
public class VehicleModule {

    @Provides
    Motor provideMotor(){
        return new Motor();
    }

    @Provides
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}
