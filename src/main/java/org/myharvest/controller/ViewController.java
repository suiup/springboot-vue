package org.myharvest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * view controller. mainly used to display html
 */
@Controller
@RestController("/")
public class ViewController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView viewsUserLogin() {
        return new ModelAndView("login");
    }

}
