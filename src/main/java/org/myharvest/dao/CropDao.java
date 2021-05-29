package org.myharvest.dao;

import org.myharvest.pojo.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropDao extends JpaRepository<Crop,Integer>{

    List<Crop> findAll();

    Crop findCropByCropId(Integer cropId);

    Crop findCropByCropName(String cropName);

    Crop findCropByUserId(Integer userId);

    Crop deleteByCropName(String cropName);

    void deleteByCropId(Integer cropId);

}