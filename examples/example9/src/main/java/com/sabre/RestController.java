package com.sabre;

import com.sabre.entities.Task;
import com.sabre.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Michal
 * 2014-11-18.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/task")
public class RestController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    @ResponseBody
    public Task getTasks(@PathVariable("id") Long id) {
        return taskRepository.findOne(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTasks(@PathVariable("id") Long id) {
        taskRepository.delete(id);
    }
}
