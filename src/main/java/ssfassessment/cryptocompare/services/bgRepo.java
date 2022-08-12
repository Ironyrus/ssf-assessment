package ssfassessment.cryptocompare.services;

import jakarta.json.JsonObject;
import ssfassessment.cryptocompare.models.artObj;

public interface bgRepo {
    public void save(String cameraData);

    public void deleteAll();

    public void saveCurrObj(artObj currConverter, int value);

    public artObj getCurrObj(String id);

}