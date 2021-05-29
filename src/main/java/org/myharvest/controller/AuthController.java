package org.myharvest.controller;

import org.myharvest.common.Message;
import org.myharvest.pojo.Auth;
import org.myharvest.pojo.User;
import org.myharvest.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Auth controller that is used to control the authentication of the system
 */
@RestController
@RequestMapping("/Auth")
public class AuthController {
    @Resource
    private AuthService authService;

    @GetMapping("/findAll")
    public Message findAll() {
        List<Auth> auth = authService.findAll();
        System.out.println(auth);
        return Message.success("successful", auth);
    }

    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody Auth auth) {
        System.out.println(auth);
        authService.add(auth);
        return Message.success();
    }

    @GetMapping("/delete/{id}")
    public Message delete(@PathVariable Integer id){
        authService.deleteByAuthId(id);
        return Message.success();
    }

    @PostMapping(value = "/edit",produces = {"application/json;charset=UTF-8"})
    public Message edit(@RequestBody Auth auth){
        System.out.println(auth);
        authService.edit(auth);
        return Message.success();
    }

    @GetMapping("/findUserById/{id}")
    public Message findAuthByAuthId(@PathVariable Integer authId){
        Auth auth = authService.findAuthByAuthId(authId);
        System.out.println(auth);
        return Message.success("success", auth);
    }

}
