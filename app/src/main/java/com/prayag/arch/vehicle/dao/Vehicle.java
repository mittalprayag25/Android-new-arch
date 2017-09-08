package com.prayag.arch.vehicle.dao;

import javax.inject.Inject;

/**
 * Created by pmittal on 21/08/17.
 */

public class Vehicle {

    private Motor motor;

    @Inject
    public Vehicle(Motor motor){
        this.motor = motor;
    }

    public void increaseSpeed(int value){
        motor.accelerate(value);
    }

    public void stop(){
        motor.brake();
    }

    public int getSpeed(){
        return motor.getRpm();
    }
}
