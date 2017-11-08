package com.prayag.arch.sla.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.prayag.arch.application.api.ServerApi;
import com.prayag.arch.application.injection.components.AppViewModelComponent;
import com.prayag.arch.application.injection.components.DaggerAppViewModelComponent;
import com.prayag.arch.application.injection.modules.AppViewModelModule;
import com.prayag.arch.application.room.AppDatabase;
import com.prayag.arch.application.room.entity.StarshipEntity;
import com.prayag.arch.sla.dao.Starship;
import com.prayag.arch.sla.dao.Starships;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class StarshipsViewModel extends AndroidViewModel {


    @Inject
    AppDatabase appDatabase;

    private AppViewModelComponent appViewModelComponent;
    private MutableLiveData<Starships> starshipsLiveData;
    Starships starships;

    public StarshipsViewModel(Application application) {
        super(application);
        if (appViewModelComponent == null) {
            appViewModelComponent = DaggerAppViewModelComponent.builder()
                    .appViewModelModule(new AppViewModelModule(application))
                    .build();
        }
        appViewModelComponent.inject(StarshipsViewModel.this);
        starshipsLiveData = ServerApi.getInstance().getStarships();

    }

    public void saveStarshipsData(Starships starshipsLiveData) {
        starships = starshipsLiveData;
        List<Starship> starShipList = starships.getStarshipArrayList();
        Starship starship = starShipList.get(2);
        starShipList.add(2, starship);
        StarshipEntity starshipEntity  = new StarshipEntity(starship);
        appDatabase.starshipsDao().addStarship(starshipEntity);


    }

    /**
     * @return
     */
    public MutableLiveData<Starships> getStarshipsObservable() {
        return starshipsLiveData;
    }

    /**
     *
     * @param starshipObject
     */
    public void changeMessage(Starship starshipObject) {
        StarshipEntity starshipEntity = new StarshipEntity(starshipObject);
        appDatabase.starshipsDao().updateStarShip(starshipEntity);
        List<StarshipEntity> entityList = appDatabase.starshipsDao().getStarships();
        starshipsLiveData.setValue(starships);
    }
}
