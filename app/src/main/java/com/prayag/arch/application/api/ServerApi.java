package com.prayag.arch.application.api;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.user.dao.TechStack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by pmittal on 12/09/17.
 */

public class ServerApi implements ServerRepository{
    private ServiceEndpoint serviceEndpoint;
    private static ServerApi serverApi;

    private ServerApi() {
        //TODO this serviceEndpoint instance will be injected using Dagger in part #2 ...
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceEndpoint.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceEndpoint = retrofit.create(ServiceEndpoint.class);
    }

    public synchronized static ServerApi getInstance() {
        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        if (serverApi == null) {
            if (serverApi == null) {
                serverApi = new ServerApi();
            }
        }
        return serverApi;
    }

    @Override
    public MutableLiveData<List<TechStack>> getProjectList() {
        final MutableLiveData<List<TechStack>> data = new MutableLiveData<>();
        Log.d("Respoinse", "MutableLiveData");
        serviceEndpoint.getProjectList().enqueue(new Callback<List<TechStack>>() {
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

    @Override
    public MutableLiveData<List<CitizenAlert>> getCitizenAlerts() {
        final MutableLiveData<List<CitizenAlert>> citizenAlertData = new MutableLiveData<List<CitizenAlert>>();
        serviceEndpoint.getCitizenAlerts().enqueue(new Callback<List<CitizenAlert>>() {
            @Override
            public void onResponse(Call<List<CitizenAlert>> call, Response<List<CitizenAlert>> response) {
                citizenAlertData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CitizenAlert>> call, Throwable t) {

            }
        });
        return citizenAlertData;
    }

    @Override
    public MutableLiveData<Planets> getPlanets() {
        final MutableLiveData<Planets> planets = new MutableLiveData<Planets>();
        serviceEndpoint.getPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                Log.d("Planets response", String.valueOf(response.body().getResults().size()));
                planets.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                Log.d("Planets Failure", t.getMessage());
            }
        });
        return planets;
    }

}