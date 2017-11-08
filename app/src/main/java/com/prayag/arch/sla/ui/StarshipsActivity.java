package com.prayag.arch.sla.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.prayag.arch.R;
import com.prayag.arch.application.UniverseApplication;
import com.prayag.arch.sla.dao.Starship;
import com.prayag.arch.sla.dao.Starships;
import com.prayag.arch.sla.injection.components.DaggerSlaComponent;
import com.prayag.arch.sla.injection.components.SlaComponent;
import com.prayag.arch.sla.injection.modules.SlaModule;
import com.prayag.arch.sla.viewmodel.StarshipsViewModel;

/**
 * Created by pmittal on 31/10/17.
 */

public class StarshipsActivity extends LifecycleActivity implements View.OnClickListener{

    private SlaComponent slaComponent;
    private StarshipsViewModel starshipsViewModel;
    private Button updateValueButton;


    Starships starshipData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        getSlaComponent().inject(this);
        setViews();
        starshipsViewModel = ViewModelProviders.of(this).get(StarshipsViewModel.class);
        observeViewModel(starshipsViewModel);
    }

    private void setViews() {
        updateValueButton = (Button)findViewById(R.id.updateValue);
    }

    /**
     *
     * @param starshipsViewModel
     */
    private void observeViewModel(StarshipsViewModel starshipsViewModel) {
        starshipsViewModel.getStarshipsObservable().observe(this, new Observer<Starships>() {
            @Override
            public void onChanged(@Nullable Starships starships) {
                Log.d("SLAVIEWMODEKL", starships.getNext());
                starshipData = starships;
                starshipsViewModel.saveStarshipsData(starshipData);
            }
        });
    }

    private SlaComponent getSlaComponent() {
        if(slaComponent == null){
            slaComponent = DaggerSlaComponent.builder().slaModule(new SlaModule(this))
                    .applicationComponent(UniverseApplication.get(this).getComponent()).build();
        }
        return slaComponent;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.updateValue:
                changeMessage();
                break;
        }
    }

    private void changeMessage() {
        Starship starship = starshipData.getStarshipArrayList().get(2);
        starship.setName("Prayag");
        starshipsViewModel.changeMessage(starship);
    }
}
