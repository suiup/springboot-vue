package org.myharvest.controller;

import org.myharvest.common.Message;
import org.myharvest.pojo.Role;
import org.myharvest.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Role controller
 */
@RestController
@RequestMapping("/Role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * find all contacts in the database
     *
     * @return
     */
    @GetMapping("/findAll")
    public Message findAll() {
        List<Role> roles = roleService.findAll();
        System.out.println(roles);
        return Message.success("successful", roles);
    }

    @GetMapping("/delete/{id}")
    public Message delete(@PathVariable Integer id) {
        roleService.deleteById(id);
        return Message.success();
    }

    /**
     * add role
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody Role role) {
        roleService.add(role);
        return Message.success();
    }
}
