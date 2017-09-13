package com.prayag.arch.daggerexample.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
public class TechStack {

    int id;
    String tech;

    @Inject
    public TechStack(int id, String tech) {
        this.id = id;
        this.tech = tech;
    }

    public TechStack() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
