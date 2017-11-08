package com.prayag.arch.application.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.prayag.arch.application.room.converter.DataTypeConverter;
import com.prayag.arch.sla.dao.Starship;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

@Entity(tableName = StarshipEntity.TABLE_NAME)
@TypeConverters(DataTypeConverter.class)
public class StarshipEntity {

    public static final String TABLE_NAME = "starship";
    public static final String PILOT = "pilot";
    public static final String FILMS = "flims";

    @PrimaryKey
    String name;
    String model;
    String manufacturer;
    String costInCredits;
    String length;
    String maxAtmospheringSpeed;
    String crew;
    String passengers;
    String cargoCapacity;
    String consumables;
    String hyperdriveRating;
    String mglt;
    String starshipClass;
    String created;
    String edited;
    String url;
    @ColumnInfo(name = PILOT)
    String pilots;
    @ColumnInfo(name = FILMS)
    String films;

    @Inject
    public StarshipEntity(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmospheringSpeed, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String mglt, String starshipClass, String created, String edited, String url, String pilots, String films) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.mglt = mglt;
        this.starshipClass = starshipClass;
        this.created = created;
        this.edited = edited;
        this.url = url;
        this.pilots = pilots;
        this.films = films;
    }

    public StarshipEntity(Starship starship) {
        this.name = starship.getName();
        this.model = starship.getModel();
        this.manufacturer = starship.getManufacturer();
        this.costInCredits = starship.getCostInCredits();
        this.length = starship.getLength();
        this.maxAtmospheringSpeed = starship.getMaxAtmospheringSpeed();
        this.crew = starship.getCrew();
        this.passengers = starship.getPassengers();
        this.cargoCapacity = starship.getCargoCapacity();
        this.consumables = starship.getConsumables();
        this.hyperdriveRating = starship.getHyperdriveRating();
        this.mglt = starship.getMglt();
        this.starshipClass = starship.getStarshipClass();
        this.created = starship.getCreated();
        this.edited = starship.getEdited();
        this.url = starship.getUrl();
        this.pilots = null;
        this.films = null;
    }


    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getPILOT() {
        return PILOT;
    }

    public static String getFILMS() {
        return FILMS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPilots() {
        return pilots;
    }

    public void setPilots(String pilots) {
        this.pilots = pilots;
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }
}