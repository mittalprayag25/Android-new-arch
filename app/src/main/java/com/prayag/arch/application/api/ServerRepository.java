package com.prayag.arch.application.api;

import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.daggerexample.dao.TechStack;

import java.util.List;

/**
 * Created by pmittal on 05/10/17.
 */

public interface ServerRepository {
    public MutableLiveData<List<TechStack>> getProjectList();
}