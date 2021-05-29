package org.myharvest.controller;

import org.myharvest.common.Message;
import org.myharvest.pojo.Contact;
import org.myharvest.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Contact)controller
 *
 * @author Chuqing Jian
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Resource
    private ContactService contactService;

    /**
     * add contact
     *
     * @param contact
     * @return
     */
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Message add(@RequestBody Contact contact) {
        System.out.println(contact);
        contactService.add(contact);
        return Message.success();
    }


    /**
     * delete log
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteContactById/{id}")
    public Message deleteContactById(@PathVariable Long id) {
        Long selectContactId = id;
        contactService.deleteById(id);
        return Message.success("success", selectContactId);
    }


    /**
     * find all contacts in the database
     *
     * @return
     */
    @GetMapping("/findAll")
    public Message findAll() {
        List<Contact> contacts = contactService.findAll();
        System.out.println(contacts);
        return Message.success("successful", contacts);
    }

    /**
     * find contact by Id in the database
     *
     * @param
     * @return
     */
    @GetMapping("/findContactById/{id}")
    public Message findContactById(@PathVariable Long id) {
        Contact contact = contactService.findContactById(id);
        System.out.println(contact);
        return Message.success("success", contact);
    }
}
