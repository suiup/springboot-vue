package org.myharvest.controller;

import org.myharvest.common.Message;
import org.myharvest.pojo.Crop;
import org.myharvest.pojo.User;
import org.myharvest.service.CropService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * to receive commands that are relevant to crops
 */
@RestController
@RequestMapping("/Crop")
public class CropController {

    @Resource
    private CropService cropService;

    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody Crop crop) {
        System.out.println(crop);
        if(crop.getUserId() == null){
            return Message.fail("Sorry, you need to login first");
        }
        cropService.add(crop);
        return Message.success();
    }

    @GetMapping("/findAll")
    public Message findAll() {
        List<Crop> crop = cropService.findAll();
        System.out.println(crop);
        return Message.success("successful", crop);
    }

    @GetMapping("/delete/{id}")
    public Message delete(@PathVariable Integer id){
        cropService.deleteByCropId(id);
        return Message.success();
    }

    @PostMapping(value = "/edit",produces = {"application/json;charset=UTF-8"})
    public Message edit(@RequestBody Crop crop){
        System.out.println(crop);
        cropService.edit(crop);
        return Message.success();
    }


}
