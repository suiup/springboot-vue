package org.myharvest.service.impl;

import org.myharvest.dao.CropDao;
import org.myharvest.pojo.Crop;
import org.myharvest.service.CropService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CropServiceImpl implements CropService {


    @Resource
    private CropDao cropDao;

    @Override
    public void add(Crop crop) {
        cropDao.save(crop);
    }

    @Override
    public void edit(Crop crop) {
        cropDao.save(crop);
    }

    @Override
    public List<Crop> findAll() {
        return cropDao.findAll();
    }

    @Override
    public Crop findCropByCropId(Integer cropId){
        Crop crop = cropDao.findCropByCropId(cropId);
        if(crop == null){
            return null;
        }
        System.out.println(crop);
        String username = crop.getCropName();
        System.out.println(crop);
        return crop;
    }

    @Override
    public Crop findCropByCropName(String cropName) {
        Crop crop = cropDao.findCropByCropName(cropName);
        if(crop == null){
            return null;
        }
        System.out.println(crop);
        Integer cropId = crop.getCropId();
        System.out.println(crop);
        return crop;
    }

    @Override
    public Crop findCropByUserId(Integer userId){
        Crop crop = cropDao.findCropByCropId(userId);
        if(crop == null){
            return null;
        }
        System.out.println(crop);
        String cropname = crop.getCropName();
        System.out.println(crop);
        return crop;
    }

    @Override
    public Crop findCropByUserName(String cropName){
        Crop crop = cropDao.findCropByCropName(cropName);
        if(crop == null){
            return null;
        }
        System.out.println(crop);
        Integer cropid = crop.getCropId();
        System.out.println(crop);
        return crop;
    }

    @Override
    public void deleteByCropName(String cropName) {
        cropDao.deleteByCropName(cropName);
    }

    @Override
    public void deleteByCropId(Integer id) {
        cropDao.deleteByCropId(id);
    }

}
