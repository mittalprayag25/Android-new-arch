package com.prayag.arch.application.room.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.prayag.arch.application.room.entity.Citizen;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CitizenDao {

    @Query("SELECT * FROM " + Citizen.TABLE_NAME)
    List<Citizen> getCitizenAlerts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCitizenAlert(Citizen citizenAlert);

    @Delete
    void deleteCitizenAlert(Citizen citizenAlert);

    @Update(onConflict = REPLACE)
    void updateCitizenAlert(Citizen citizenAlert);

}
