package com.prayag.arch.mmvm.SelfLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import com.prayag.arch.CountdownApplication;
import com.prayag.arch.mmvm.SelfLearn.beans.Company;
import com.prayag.arch.mmvm.dagger2Impl.DataManager;
import com.prayag.arch.mmvm.dagger2Impl.User;

/**
 * Created by pmittal on 05/09/17.
 */

public class DaggerSelfActivity extends AppCompatActivity {
    Company company;

    @Inject
    DataManager mDataManager;

    SelfComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        company = component.provideCompany();
        Log.d("companyName ",company.getCompanyName());

        createUser();
    }

    public SelfComponent getActivityComponent() {
        if (component == null) {
            component = DaggerSelfComponent.builder()
                    .selfModule(new SelfModule())
                    .applicationComponent(CountdownApplication.get(this).getComponent())
                    .build();
        }
        return component;
    }


    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }


}
