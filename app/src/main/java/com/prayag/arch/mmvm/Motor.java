package com.prayag.arch.mmvm;

/**
 * Created by pmittal on 21/08/17.
 */

public class Motor {
    private int rpm;

    public Motor(){
        this.rpm = 0;
    }

    public int getRpm(){
        return rpm;
    }

    public void accelerate(int value){
        this.rpm = rpm + value;
    }

    public void brake(){
        rpm = 0;
    }
}
