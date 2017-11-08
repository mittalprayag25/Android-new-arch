package com.prayag.arch.application.api;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.prayag.arch.planets.dao.Planets;
import com.prayag.arch.sla.dao.Starships;

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
    public MutableLiveData<Starships> getStarships() {
        final MutableLiveData<Starships> starships = new MutableLiveData<Starships>();
        serviceEndpoint.getStarships().enqueue(new Callback<Starships>() {
            @Override
            public void onResponse(Call<Starships> call, Response<Starships> response) {
                starships.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Starships> call, Throwable t) {

            }
        });
        return starships;
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