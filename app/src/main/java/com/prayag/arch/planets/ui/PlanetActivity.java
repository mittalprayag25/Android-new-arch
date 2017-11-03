package com.prayag.arch.planets.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.planets.injection.components.DaggerPlanetComponent;
import com.prayag.arch.planets.injection.components.PlanetComponent;
import com.prayag.arch.planets.injection.modules.PlanetModule;
import com.prayag.arch.planets.viewmodel.PlanetViewModel;
import com.prayag.arch.sla.injection.components.DaggerSlaComponent;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class PlanetActivity extends LifecycleActivity implements View.OnClickListener{

    private PlanetComponent planetComponent;
    private PlanetViewModel planetViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        getSlaComponent().inject(this);
        setViews();
        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);
        observeViewModel(planetViewModel);
    }

    private void setViews() {

    }

    private void observeViewModel(PlanetViewModel planetViewModel) {
        planetViewModel.getPlanetListObservable().observe(this, new Observer<Planets>() {
            @Override
            public void onChanged(@Nullable Planets planets) {
                Log.d("PLanets", planets.getPlanet().get(0).getName());
            }
        });
    }

    private PlanetComponent getSlaComponent() {
        if(planetComponent == null){
            planetComponent = DaggerPlanetComponent.builder().planetModule(new PlanetModule(this))
                    .applicationComponent(CountdownApplication.get(this).getComponent()).build();
        }
        return planetComponent;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.updateValue:
                break;
        }
    }
}
