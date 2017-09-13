package com.prayag.arch.daggerexample.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.prayag.arch.daggerexample.dao.TechStack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by pmittal on 12/09/17.
 */

public class ProjectRepository {
    private GitHubService gitHubService;
    private static ProjectRepository projectRepository;

    private ProjectRepository() {
        //TODO this gitHubService instance will be injected using Dagger in part #2 ...
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubService = retrofit.create(GitHubService.class);
    }

    public synchronized static ProjectRepository getInstance() {
        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        if (projectRepository == null) {
            if (projectRepository == null) {
                projectRepository = new ProjectRepository();
            }
        }
        return projectRepository;
    }
    public MutableLiveData<List<TechStack>> getProjectList() {
        final MutableLiveData<List<TechStack>> data = new MutableLiveData<>();
        Log.d("Respoinse", "MutableLiveData");
        gitHubService.getProjectList().enqueue(new Callback<List<TechStack>>() {
            @Override
            public void onResponse(Call<List<TechStack>> call, Response<List<TechStack>> response) {
                Log.d("Respoinse", "response");
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TechStack>> call, Throwable t) {
                Log.d("Respoinse", t.getMessage().toString());
            }

        });

        return data;
    }


}