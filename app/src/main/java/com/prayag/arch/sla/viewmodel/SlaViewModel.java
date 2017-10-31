package com.prayag.arch.sla.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.user.dao.User;

import java.util.List;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaViewModel extends AndroidViewModel {

    MutableLiveData<List<CitizenAlert>> citizenLiveData;

    public SlaViewModel(Application application) {
        super(application);
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
    }
}
