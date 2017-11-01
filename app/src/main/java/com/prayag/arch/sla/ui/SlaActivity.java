package com.prayag.arch.sla.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.sla.injection.components.DaggerSlaComponent;
import com.prayag.arch.sla.injection.components.SlaComponent;
import com.prayag.arch.sla.injection.modules.SlaModule;
import com.prayag.arch.sla.viewmodel.SlaViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaActivity extends LifecycleActivity implements View.OnClickListener{

    private SlaComponent slaComponent;
    private SlaViewModel slaViewModel;
    private Button updateValueButton;

    @Inject
    CitizenAlert citizenAlert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        getSlaComponent().inject(this);
        setViews();
        slaViewModel = ViewModelProviders.of(this).get(SlaViewModel.class);
        observeViewModel(slaViewModel);
    }

    private void setViews() {
        updateValueButton = (Button)findViewById(R.id.updateValue);
    }

    private void observeViewModel(SlaViewModel slaViewModel) {
        slaViewModel.getcitizenListObservable().observe(this, new Observer<List<CitizenAlert>>() {
            @Override
            public void onChanged(@Nullable List<CitizenAlert> citizenAlerts) {
                Log.d("SLAVIEWMODEKL", citizenAlerts.get(0).getMessage());
            }
        });
    }

    private SlaComponent getSlaComponent() {
        if(slaComponent == null){
            slaComponent = DaggerSlaComponent.builder().slaModule(new SlaModule(this))
                    .applicationComponent(CountdownApplication.get(this).getComponent()).build();
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
        slaViewModel.changeMessage("Hey I am updated");
    }
}
