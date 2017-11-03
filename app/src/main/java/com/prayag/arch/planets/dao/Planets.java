package com.prayag.arch.planets.dao;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 31/10/17.
 */

@Singleton
public class Planets {

    String count;
    String next;
    String previous;
    ArrayList<Planet> results;

    @Inject
    public Planets(String count, String next, String previous, ArrayList<Planet> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Planets() {

    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Planet> getPlanet() {
        return results;
    }

    public void setPlanet(ArrayList<Planet> planet) {
        this.results = planet;
    }
}