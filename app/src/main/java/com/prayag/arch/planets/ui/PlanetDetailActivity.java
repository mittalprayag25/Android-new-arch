package com.prayag.arch.planets.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.planets.dao.Planet;
import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.planets.injection.components.DaggerPlanetComponent;
import com.prayag.arch.planets.injection.components.PlanetComponent;
import com.prayag.arch.planets.injection.modules.PlanetModule;
import com.prayag.arch.planets.viewmodel.PlanetViewModel;

/**
 * Created by pmittal on 03/11/17.
 */

public class PlanetDetailActivity extends LifecycleActivity {

    private PlanetComponent planetComponent;
    private PlanetViewModel planetViewModel;
    private TextView textViewName;
    private TextView textViewTerrain;
    private TextView textViewRotation;
    private TextView textViewClimate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_detail);
        getPlanetComponent().inject(this);
        setViews();
        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);
        observeViewModel(planetViewModel);
    }

    private void setViews() {
        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewTerrain = (TextView)findViewById(R.id.textViewTerrain);
        textViewRotation = (TextView)findViewById(R.id.textViewRotation);
        textViewClimate = (TextView)findViewById(R.id.textViewClimate);
    }

    private PlanetComponent getPlanetComponent() {
        if(planetComponent == null){
            planetComponent = DaggerPlanetComponent.builder().planetModule(new PlanetModule(this))
                    .applicationComponent(CountdownApplication.get(this).getComponent()).build();
        }
        return planetComponent;
    }

    private void observeViewModel(PlanetViewModel planetViewModel) {
        planetViewModel.getPlanetListObservable().observe(this, new Observer<Planet>() {
            @Override
            public void onChanged(@Nullable Planet planet) {
                if(planet != null) {
                    Log.d("PLanetsDetail", planet.getName());
                    textViewName.setText(planet.getName());
                }

            }
        });
    }


}
