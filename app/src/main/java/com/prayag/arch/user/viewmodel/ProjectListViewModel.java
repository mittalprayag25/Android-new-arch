package com.prayag.arch.user.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.user.dao.TechStack;
import com.prayag.arch.user.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmittal on 11/09/17.
 */

public class ProjectListViewModel extends AndroidViewModel {

    private MutableLiveData<List<TechStack>> projectListObservable;
    private MutableLiveData<List<TechStack>> testData;
    private MutableLiveData<List<User>> userLive;
    static int va = 1;

    public ProjectListViewModel(Application application) {
        super(application);
        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = ServerApi.getInstance().getProjectList();
        testData = ServerApi.getInstance().getProjectList();
        userLive = new MutableLiveData<List<User>>();
    }
    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<TechStack>> getProjectListObservable() {
        return projectListObservable;
    }
    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<TechStack>> getTestData() {
        return testData;
    }

    public LiveData<List<User>> getUpdatedUser(){
        return userLive;
    }

    public void addItem(TechStack techStack) {
        List<TechStack> tech = new ArrayList<TechStack>();
        tech = projectListObservable.getValue();
        tech.add(techStack);
        projectListObservable.setValue(tech);
        testData.setValue(tech);
    }


    /**
     *
     * @param mDataManager
     */
    public void addUser(DataManager mDataManager){
        try {
            int c = va +1;
            mDataManager.createUser(new User("Ali"+String.valueOf(c), "1367, Gurgaon, Haryana, India"));

            List<User> userList = new ArrayList<User>();

            if(userLive.getValue() != null){
                userList = userLive.getValue();

            }
            User user = mDataManager.getUser(1L);

            userList.add(user);
            userLive.setValue(userList);
        }catch (Exception e){e.printStackTrace();}
    }


    /**
     *
     * @param mDataManager
     */
    public void deleteUser(DataManager mDataManager){
        try {
            User user = mDataManager.getUser(1L);
        }catch (Exception e){e.printStackTrace();}
    }

}