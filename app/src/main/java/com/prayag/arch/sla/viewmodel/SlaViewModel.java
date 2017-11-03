package com.prayag.arch.sla.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.application.injection.components.AppViewModelComponent;
import com.prayag.arch.application.injection.components.DaggerAppViewModelComponent;
import com.prayag.arch.sla.dao.TestGag;
import com.prayag.arch.application.room.AppDatabase;
import com.prayag.arch.application.room.entity.Citizen;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.application.injection.modules.AppViewModelModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaViewModel extends AndroidViewModel {

    @Inject
    TestGag testGag;

    @Inject
    AppDatabase appDatabase;

    private AppViewModelComponent appViewModelComponent;
    private MutableLiveData<List<CitizenAlert>> citizenAlertLiveData;

    public SlaViewModel(Application application) {
        super(application);
        if(appViewModelComponent == null){
            appViewModelComponent = DaggerAppViewModelComponent.builder()
                    .appViewModelModule(new AppViewModelModule(application))
                    .build();
        }
        appViewModelComponent.inject(SlaViewModel.this);
        Log.d("SLAFRAGMENT", testGag.getName());
        citizenAlertLiveData = ServerApi.getInstance().getCitizenAlerts();

    }

    /**
     *
     * @return
     */
    public MutableLiveData<List<CitizenAlert>> getcitizenListObservable(){
        return citizenAlertLiveData;
    }

    /**
     *
     * @param s
     */
    public void changeMessage(String s) {
        Citizen citizen = new Citizen(citizenAlertLiveData.getValue().get(1).getType(),citizenAlertLiveData.getValue().get(1).getRequestId(),
                citizenAlertLiveData.getValue().get(1).getMessage(), citizenAlertLiveData.getValue().get(1).getDueDate());
        appDatabase.citizenDao().addCitizenAlert(citizen);

        List<Citizen> list = appDatabase.citizenDao().getCitizenAlerts();
        list.size();

        List<CitizenAlert> citizenAlertsList = citizenAlertLiveData.getValue();
        CitizenAlert citizenAlert = citizenAlertsList.get(0);
        citizenAlert.setMessage(s);
        citizenAlertsList.add(0, citizenAlert);
        citizenAlertLiveData.setValue(citizenAlertsList);

      //  AppDatabase appDatabase = AppDatabase.getInstance(application).eventDao().addEvent();



    }
}
