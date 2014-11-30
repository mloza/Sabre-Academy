package com.sabre;

import com.sabre.entities.Task;
import com.sabre.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michal
 * 2014-11-17.
 */
@EnableAutoConfiguration
@Controller
@ComponentScan
@EnableJpaRepositories(basePackageClasses = TaskRepository.class)
public class ApplicationReady {

    @Autowired
    public TaskRepository taskRepository;


    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationReady.class, args);
    }
}
