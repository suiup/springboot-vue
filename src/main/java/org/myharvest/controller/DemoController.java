package org.myharvest.controller;

import org.myharvest.common.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is a demo controller. To show how to use this framewolk and how to
 * connect html and springboot
 */
@RestController
@RequestMapping("/Demo")
public class DemoController {


    /**
     * Testing whether it is successful to pass value to the web page
     *
     * @return
     */
    @GetMapping("/demo01")
    public ModelAndView demo01() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index02");
        modelAndView.addObject("name", "world");
        return modelAndView;
    }

    /**
     * receiving data from web page
     *
     * @param request
     * @return
     */
    @PostMapping("/demo02")
    public Message demo03(@RequestBody String request) {
        System.out.println(request);
        return Message.success();
    }

    @GetMapping("/database")
    public ModelAndView database() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("database");
        return modelAndView;
    }

    @GetMapping("/testCI")
    public ModelAndView testCI(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testCI");
        return modelAndView;
    }
}
