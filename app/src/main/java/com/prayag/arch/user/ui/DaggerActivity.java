package com.prayag.arch.user.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.application.data.SharedPrefsHelper;
import com.prayag.arch.sla.ui.SlaActivity;
import com.prayag.arch.user.dao.TechStack;
import com.prayag.arch.user.injection.components.DaggerUserComponent;
import com.prayag.arch.user.injection.components.UserComponent;
import com.prayag.arch.user.injection.modules.UserModule;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.user.dao.User;
import com.prayag.arch.user.viewmodel.ProjectListViewModel;

import java.util.List;

/**
 * Created by pmittal on 28/08/17.
 */

public class DaggerActivity extends LifecycleActivity implements View.OnClickListener{

    @Inject
    DataManager mDataManager;

    @Inject
    SharedPrefsHelper sharedPrefsHelper;

    @Inject
    TechStack techStack;

    ProjectListViewModel viewModel;

    @Inject
    Activity context;

    private UserComponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;
    private Button addUserButton, deleteUserButton;

    public UserComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerUserComponent.builder()
                    .userModule(new UserModule(this))
                    .applicationComponent(CountdownApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        viewModel = ViewModelProviders.of(this).get(ProjectListViewModel.class);
        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
        addUserButton = (Button) findViewById(R.id.addUser);
        deleteUserButton = (Button) findViewById(R.id.deleteUser);
        observeViewModel(viewModel);
        observeUser(viewModel);
        Log.d("AGE",String.valueOf(techStack.getTech()));
        sharedPrefsHelper.put("STRING", "PRWAYAG");
        Log.d("STRINGSGARED", sharedPrefsHelper.get("STRING", "MITTAL"));
    }

    private void observeUser(ProjectListViewModel viewModel) {

        viewModel.getUpdatedUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                Log.d("In Activity USer Value", String.valueOf(users.size()));
                Log.d("In Activity USer Value", users.get(0).getName().toString());

                int size = users.size();
                mTvUserInfo.setText(users.get(0).getName().toString());
            }
        });
    }
    private void observeViewModel(ProjectListViewModel viewModel) {
         viewModel.getProjectListObservable().observe(this, new Observer<List<TechStack>>() {
             @Override
             public void onChanged(@Nullable List<TechStack> techStacks) {
                 if (techStacks != null) {
                     Log.d("In Dagger Activity", String.valueOf(techStacks.size()));
                     mTvUserInfo.setText(String.valueOf(techStacks.size()));
                 }
             }
         });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addUser :
                Intent intent = new Intent(context, SlaActivity.class);
                startActivity(intent);
                viewModel.addUser(mDataManager);
                break;
            case R.id.deleteUser :
                viewModel.deleteUser(mDataManager);
                break;

        }
    }
}