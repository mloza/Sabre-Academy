package com.sabre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michal
 * 2014-11-17.
 */
@EnableAutoConfiguration
@Controller
@ComponentScan
public class ApplicationReady {

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("greetings", "Hello World!");

        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView("index2");

        modelAndView.addObject("greetings", new String[] {"Simple", "List", "Test"});

        return modelAndView;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationReady.class, args);
    }
}
