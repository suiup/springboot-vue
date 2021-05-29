package org.myharvest.service;

import org.myharvest.pojo.Crop;
import org.myharvest.pojo.User;

import java.util.List;

public interface CropService {

    void add(Crop crop);

    void edit(Crop crop);

    void deleteByCropName(String cropName);

    void deleteByCropId(Integer id);

    Crop findCropByCropId(Integer cropId);

    Crop findCropByCropName(String cropName);

    Crop findCropByUserId(Integer userId);

    Crop findCropByUserName(String cropName);

    List<Crop> findAll();

}