package za.co.riggaroo.datecountdown.mmvm;

import dagger.Component;

/**
 * Created by pmittal on 21/08/17.
 */

@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();
}
