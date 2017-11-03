package com.prayag.arch.application.api;

import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.user.dao.TechStack;

import java.util.List;

/**
 * Created by pmittal on 05/10/17.
 */

public interface ServerRepository {
    public MutableLiveData<List<TechStack>> getProjectList();

    public MutableLiveData<List<CitizenAlert>> getCitizenAlerts();

    public MutableLiveData<Planets> getPlanets();
}
