package com.prayag.arch.daggerexample.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import com.prayag.arch.R;
import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.daggerexample.dao.TechStack;
import com.prayag.arch.daggerexample.injection.components.ActivityComponent;
import com.prayag.arch.daggerexample.injection.components.DaggerActivityComponent;
import com.prayag.arch.daggerexample.injection.modules.ActivityModule;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.daggerexample.dao.User;
import com.prayag.arch.daggerexample.viewmodel.ProjectListViewModel;

import java.util.List;

/**
 * Created by pmittal on 28/08/17.
 */

public class DaggerActivity extends LifecycleActivity implements View.OnClickListener{

    @Inject
    DataManager mDataManager;

    @Inject
    TechStack techStack;

    ProjectListViewModel viewModel;

    private ActivityComponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;
    private Button addUserButton, deleteUserButton;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
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
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
     //   createUser();
      //  getUser();
//        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");
//
//        String token = mDataManager.getAccessToken();
//        if(token != null){
//            mTvAccessToken.setText(token);
//        }
    }
//
//    private void addUser(){
//        try {
//            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
//        }catch (Exception e){e.printStackTrace();}
//    }
//
//    private void getUser(){
//        try {
//            User user = mDataManager.getUser(1L);
//            mTvUserInfo.setText(user.toString());
//        }catch (Exception e){e.printStackTrace();}
//    }
//
//    private void deleteUser(){
//        try {
//            User user = mDataManager.getUser(1L);
//            mTvUserInfo.setText(user.toString());
//        }catch (Exception e){e.printStackTrace();}
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addUser :
                viewModel.addUser(mDataManager);
                break;
            case R.id.deleteUser :
                viewModel.deleteUser(mDataManager);
                break;

        }
    }
}