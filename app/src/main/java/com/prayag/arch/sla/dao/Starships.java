package com.prayag.arch.sla.dao;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 31/10/17.
 */

@Singleton
public class Starships {
    int count;
    String next;
    String previous;
    ArrayList<Starship> results;

    @Inject
    public Starships(int count, String next, String previous, ArrayList<Starship> starshipArrayList) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = starshipArrayList;
    }

    public Starships() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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

    public ArrayList<Starship> getStarshipArrayList() {
        return results;
    }

    public void setStarshipArrayList(ArrayList<Starship> starshipArrayList) {
        this.results = starshipArrayList;
    }
}
