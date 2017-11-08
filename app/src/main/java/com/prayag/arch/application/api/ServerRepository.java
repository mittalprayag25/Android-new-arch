package com.prayag.arch.application.api;

import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.sla.dao.Starships;

import java.util.List;

/**
 * Created by pmittal on 05/10/17.
 */

public interface ServerRepository {
    public MutableLiveData<Starships> getStarships();

    public MutableLiveData<Planets> getPlanets();
}
