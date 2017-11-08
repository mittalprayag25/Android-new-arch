package com.prayag.arch.planets.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.prayag.arch.R;
import com.prayag.arch.application.UniverseApplication;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.application.data.SharedPrefsHelper;
import com.prayag.arch.application.util.Constants;
import com.prayag.arch.application.util.AppPermission;
import com.prayag.arch.planets.adapter.PlanetsAdapter;
import com.prayag.arch.planets.dao.Planet;
import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.planets.injection.components.DaggerPlanetComponent;
import com.prayag.arch.planets.injection.components.PlanetComponent;
import com.prayag.arch.planets.injection.modules.PlanetModule;
import com.prayag.arch.planets.viewmodel.PlanetViewModel;
import com.prayag.arch.sla.ui.StarshipsActivity;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class PlanetActivity extends LifecycleActivity implements View.OnClickListener{

    @Inject
    DataManager mDataManager;

    @Inject
    SharedPrefsHelper sharedPrefsHelper;

    @Inject
    Activity context;

    @Inject
    AppPermission appPermission;

    private PlanetComponent planetComponent;
    private PlanetViewModel planetViewModel;
    private PlanetsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        getPlanetComponent().inject(this);

        setViews();
        //TODO Call viewmodel to get an access to data
        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);
        observeViewModel(planetViewModel);

        sharedPrefsHelper.put("access-token", "PRWAYAG");

        Log.d("PlanetActivity", sharedPrefsHelper.get("access-token", "MITTAL"));
        Log.d("PlanetDataManager", mDataManager.getAccessToken());

    }

    private void setViews() {
        setupRecyclerView();
    }

    /**
     *
     * @param planetViewModel
     */
    private void observeViewModel(PlanetViewModel planetViewModel) {
        planetViewModel.getPlanetsListObservable().observe(this, new Observer<Planets>() {
            @Override
            public void onChanged(@Nullable Planets planets) {
                if(planets.getResults().size()>0) {
                    Log.d("PLanets", planets.getResults().get(0).getName());
                    adapter.setItems(planets.getResults());
                }

            }
        });
    }

    private PlanetComponent getPlanetComponent() {
        if(planetComponent == null){
            //TODO calling application component with local activity component here to get dependencies declared in applicationComponent
            planetComponent = DaggerPlanetComponent.builder().planetModule(new PlanetModule(this))
                    .applicationComponent(UniverseApplication.get(this).getComponent()).build();
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

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab_add:
                Intent intent = new Intent(context, StarshipsActivity.class);
                startActivity(intent);
                break;
        }
    }

    private View.OnClickListener deleteClickListener = v -> {
        Planet planet = (Planet) v.getTag();
        planetViewModel.deleteEvent(planet);
        //TODO Below is a way to use Permissions. Include the Permission in this activity dagger module and inject here
        appPermission.takeUserPermission(Constants.PermissionType.CAMERA_PERMISSOIN_CODE);
    };

    private View.OnClickListener itemClickListener = v -> {
        Planet planet = (Planet) v.getTag();
        planetViewModel.planetSelected(planet);
        Toast.makeText(this, "Clicked:" + planet.getName(), Toast.LENGTH_LONG).show();
        Intent detailedPlanetIntent = new Intent(this, PlanetDetailActivity.class);
        detailedPlanetIntent.putExtra("planetBean", planet);
        startActivity(detailedPlanetIntent);
    };

    @Override
    public void onRequestPermissionsResult(final int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == Constants.PermissionType.CAMERA_PERMISSOIN_CODE) {
            if(grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("CAMERA_PERMISSOIN_CODE", "GRANTED");
                }
                else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Log.d("CAMERA_PERMISSOIN_CODE", "DENIED");
                }
            }
        }
    }
}
