package org.myharvest.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.myharvest.common.Message;
import org.myharvest.pojo.Log;
import org.myharvest.pojo.User;
import org.myharvest.service.LogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


/**
 * (Log)表控制层
 *
 * @author Chuqing Jian
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Resource
    private LogService logService;

    /**
     * add log
     * @param log
     * @return
     */
    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody Log log) {
        System.out.println(log);
        logService.add(log);
        return Message.success();
    }

    /**
     * delete log
     * @param id
     * @return
     */
    @GetMapping("/deleteLogById/{id}")
    public Message deleteLogById(@PathVariable Long id){
        Long selectLogId = id;
        logService.deleteById(id);
        return Message.success("success", selectLogId);
    }


    /**
     * find log by Id in the database
     * @param id
     * @return
     */
    @GetMapping("/findLogById/{id}")
    public Message findLogById(@PathVariable Long id){
        Log log = logService.findLogById(id);
        System.out.println(log);
        return Message.success("success", log);
    }

    /**
     * find all log in the database
     * @return
     */
    @GetMapping("/findAll")
    public Message findAll() {
        List<Log> logs = logService.findAll();
        System.out.println(logs);
        return Message.success("success", logs);
    }
}
