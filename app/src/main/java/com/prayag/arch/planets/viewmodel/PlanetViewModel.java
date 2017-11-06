package com.prayag.arch.planets.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.application.injection.components.AppViewModelComponent;
import com.prayag.arch.application.injection.components.DaggerAppViewModelComponent;
import com.prayag.arch.application.injection.modules.AppViewModelModule;
import com.prayag.arch.application.room.AppDatabase;
import com.prayag.arch.application.room.entity.Citizen;
import com.prayag.arch.planets.dao.Planet;
import com.prayag.arch.planets.dao.Planets;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class PlanetViewModel extends AndroidViewModel {


    @Inject
    AppDatabase adb;

    AppViewModelComponent appViewModelComponent;
    Application application;

    MutableLiveData<Planets> planetsLiveData;
    MutableLiveData<Planet> planetLiveData = new MutableLiveData<Planet>();

    /**
     *
     * @param application
     */
    public PlanetViewModel(Application application) {
        super(application);
        this.application = application;
        if(appViewModelComponent == null){
            appViewModelComponent = DaggerAppViewModelComponent.builder()
                    .appViewModelModule(new AppViewModelModule(application))
                    .build();
        }
        appViewModelComponent.inject(PlanetViewModel.this);
        planetsLiveData = ServerApi.getInstance().getPlanets();

    }

    /**
     *
     * @return
     */
    public MutableLiveData<Planets> getPlanetsListObservable(){
        return planetsLiveData;
    }

    /**
     *
     * @return
     */
    public MutableLiveData<Planet> getPlanetListObservable(){
        return planetLiveData;
    }

    /**
     *
     * @param planet
     */
    public void deleteEvent(Planet planet) {
        Planets planets = planetsLiveData.getValue();
        planets.getResults().remove(planet);
        planetsLiveData.postValue(planets);
    }

    /**
     *
     * @param planet
     */
    public void planetSelected(Planet planet){
        planetLiveData.setValue(planet);
    }

    public String test(){
        return "prayag";
    }
}
