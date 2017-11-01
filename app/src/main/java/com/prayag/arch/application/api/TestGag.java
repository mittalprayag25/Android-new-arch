package com.prayag.arch.application.api;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 31/10/17.
 */

@Singleton
public class TestGag {

    int id;
    String name;

    @Inject
    public TestGag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestGag() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "SUSUSUSS";
    }

    public void setName(String name) {
        this.name = name;
    }
}
