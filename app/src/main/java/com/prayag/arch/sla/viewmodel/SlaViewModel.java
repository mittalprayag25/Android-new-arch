package com.prayag.arch.sla.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.application.api.TestGag;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.sla.injection.components.DaggerSlaViewModelComponent;
import com.prayag.arch.sla.injection.components.SlaViewModelComponent;
import com.prayag.arch.sla.injection.modules.SlaViewModelModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaViewModel extends AndroidViewModel {

    @Inject
    TestGag testGag;
    SlaViewModelComponent slaViewModelComponent;

    MutableLiveData<List<CitizenAlert>> citizenLiveData;

    public SlaViewModel(Application application) {
        super(application);

        if(slaViewModelComponent == null){
            slaViewModelComponent = DaggerSlaViewModelComponent.builder()
                    .slaViewModelModule(new SlaViewModelModule())
                    .build();
        }
        slaViewModelComponent.inject(SlaViewModel.this);
        Log.d("SLAFRAGMENT", testGag.getName());
        citizenLiveData = ServerApi.getInstance().getCitizenAlerts();
    }

    public MutableLiveData<List<CitizenAlert>> getcitizenListObservable(){
        return citizenLiveData;
    }

    public void changeMessage(String s) {
        List<CitizenAlert> citizenAlertsList = citizenLiveData.getValue();
        CitizenAlert citizenAlert = citizenAlertsList.get(0);
        citizenAlert.setMessage(s);
        citizenAlertsList.add(0, citizenAlert);
        citizenLiveData.setValue(citizenAlertsList);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();


    }
}
