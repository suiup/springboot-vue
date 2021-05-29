package org.myharvest.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.myharvest.common.Message;
import org.myharvest.pojo.Contact;
import org.myharvest.pojo.User;
import org.myharvest.service.UserService;
import org.myharvest.vo.LoginUserVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * This is a user controller to deal with the request relevant to user
 */
@RestController
@RequestMapping("/User")
public class UserController extends ShiroController {

    @Resource
    private UserService userService;

    /**
     * find user by Id in the database
     * @param id
     * @return
     */
    @GetMapping("/findUserById/{id}")
    public Message findUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        System.out.println(user);
        return Message.success("success", user);
    }


    /**
     * login
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Message login(String username, String password) {
        Message message = doLogin(username, password);
        if (message.isSuccess()) {
            //have this session forever
            LoginUserVo vo = new LoginUserVo(user(),SecurityUtils.getSubject().getSession().getId());
            return Message.success("login successful",vo);
        }
        return message;
    }

    /**
     * check whether the user can login
     * @param username
     * @param password
     * @return
     */
    private Message doLogin(String username, String password) {
        if (isBlank(username, password)) {
            return Message.fail("username and password cannot be blank");
        }
        UsernamePasswordToken token = null;
        token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (IncorrectCredentialsException e) {
            return Message.fail("username or password is wrong");
        } catch (AuthenticationException e) {
            return Message.fail("username or password is wrong");
        }
        return Message.success();
    }

    private boolean isBlank(String... str) {
        for (String s : str) {
            if (isBlank(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().equals("");
    }

    /**
     * jump to index page
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * add user
     * @param user
     * @return
     */
    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody User user) {
        System.out.println(user);
        userService.add(user);
        return Message.success();
    }

    /**
     * delete by id
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public Message delete(@PathVariable Integer id){
        userService.deleteById(id);
        return Message.success();
    }

    /**
     * edit user
     * @param user
     * @return
     */
    @PostMapping(value = "/edit",produces = {"application/json;charset=UTF-8"})
    public Message edit(@RequestBody User user){
        System.out.println(user);
        userService.edit(user);
        return Message.success();
    }

    /**
     * find all users in the database
     * @return
     */
    @GetMapping("/findAll")
    public Message findAll() {
        List<User> users = userService.findAll();
        System.out.println(users);
        return Message.success("successful", users);
    }

}
