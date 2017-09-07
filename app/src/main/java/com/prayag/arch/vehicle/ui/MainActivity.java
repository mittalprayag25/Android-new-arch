package com.prayag.arch.vehicle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.prayag.arch.vehicle.dao.Vehicle;
import com.prayag.arch.vehicle.injection.components.DaggerVehicleComponent;
import com.prayag.arch.vehicle.injection.components.VehicleComponent;
import com.prayag.arch.vehicle.injection.modules.VehicleModule;

/**
 * Created by pmittal on 21/08/17.
 */

public class MainActivity extends AppCompatActivity {

    Vehicle vehicle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        vehicle = component.provideVehicle();

        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_LONG).show();

        vehicle.increaseSpeed(10);
        Toast.makeText(this, String.valueOf(vehicle.getSpeed()), Toast.LENGTH_SHORT).show();

    }
}
