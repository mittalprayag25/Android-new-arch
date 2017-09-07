package com.prayag.arch.daggerexample.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pmittal on 28/08/17.
 */

@Singleton
public class Person {

    int age;
    String namre;

    @Inject
    public Person(int age, String namre) {
        this.age = age;
        this.namre = namre;
    }

    public Person() {
    }

    public int getAge() {
        return 23;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNamre() {
        return namre;
    }

    public void setNamre(String namre) {
        this.namre = namre;
    }
}
