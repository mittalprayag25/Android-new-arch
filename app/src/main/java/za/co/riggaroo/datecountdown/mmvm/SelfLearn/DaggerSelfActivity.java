package za.co.riggaroo.datecountdown.mmvm.SelfLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import za.co.riggaroo.datecountdown.CountdownApplication;
import za.co.riggaroo.datecountdown.mmvm.SelfLearn.beans.Company;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.ActivityComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.ActivityModule;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DaggerActivityComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DataManager;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.User;

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
