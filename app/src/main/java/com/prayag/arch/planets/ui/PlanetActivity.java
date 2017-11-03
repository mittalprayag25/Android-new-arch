package com.prayag.arch.planets.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.planets.adapter.PlanetsAdapter;
import com.prayag.arch.planets.dao.Planet;
import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.planets.injection.components.DaggerPlanetComponent;
import com.prayag.arch.planets.injection.components.PlanetComponent;
import com.prayag.arch.planets.injection.modules.PlanetModule;
import com.prayag.arch.planets.viewmodel.PlanetViewModel;

import java.util.ArrayList;

/**
 * Created by pmittal on 31/10/17.
 */

public class PlanetActivity extends LifecycleActivity implements View.OnClickListener{

    private PlanetComponent planetComponent;
    private PlanetViewModel planetViewModel;
    private PlanetsAdapter adapter;

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
        setupRecyclerView();
    }

    private void observeViewModel(PlanetViewModel planetViewModel) {
        planetViewModel.getPlanetListObservable().observe(this, new Observer<Planets>() {
            @Override
            public void onChanged(@Nullable Planets planets) {
                if(planets.getResults().size()>0) {
                    Log.d("PLanets", planets.getResults().get(0).getName());
                    adapter.setItems(planets.getResults());
                }

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

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view_list_events);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PlanetsAdapter(new ArrayList<>(), this, itemClickListener, deleteClickListener);
        recyclerView.setAdapter(adapter);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.updateValue:
                break;
        }
    }

    private View.OnClickListener deleteClickListener = v -> {
        Planet planet = (Planet) v.getTag();
        planetViewModel.deleteEvent(planet);
    };

    private View.OnClickListener itemClickListener = v -> {
        Planet event = (Planet) v.getTag();
        Toast.makeText(this, "Clicked:" + event.getName(), Toast.LENGTH_LONG).show();
    };

}
