package com.prayag.arch.daggerexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.daggerexample.dao.TechStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmittal on 11/09/17.
 */

public class ProjectListViewModel extends AndroidViewModel {
    private MutableLiveData<List<TechStack>> projectListObservable;
    private MutableLiveData<List<TechStack>> testData;

    public ProjectListViewModel(Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = ServerApi.getInstance().getProjectList();
        testData = ServerApi.getInstance().getProjectList();
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

    public void addItem(TechStack techStack) {
        List<TechStack> tech = new ArrayList<TechStack>();
        tech = projectListObservable.getValue();
        tech.add(techStack);
        projectListObservable.setValue(tech);
        testData.setValue(tech);
    }
}