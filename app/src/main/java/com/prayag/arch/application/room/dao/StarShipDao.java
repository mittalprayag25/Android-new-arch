package com.prayag.arch.application.room.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.prayag.arch.application.room.entity.StarshipEntity;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface StarShipDao {

    @Query("SELECT * FROM " + StarshipEntity.TABLE_NAME)
    List<StarshipEntity> getStarships();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStarship(StarshipEntity starshipEntity);

    @Delete
    void deleteStarship(StarshipEntity starshipEntityAlert);

    @Update(onConflict = REPLACE)
    void updateStarShip(StarshipEntity starshipEntity);

}
