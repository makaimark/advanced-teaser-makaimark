package com.todoapp.controller;

import com.todoapp.Status;
import com.todoapp.Task;
import com.todoapp.database.implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService service) {
        this.taskService = service;
    }

    @RequestMapping("/")
    public ModelAndView welcome(@RequestParam(value="name", required = false, defaultValue = "World") String name) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        return new ModelAndView("index", params);
    }

    @RequestMapping("/list")
    public ModelAndView list() throws IOException {
        Map<String, Iterable<Task>> params = new HashMap<>();
        params.put("todos", taskService.listAllTask());
        return new ModelAndView("index", params);
    }

    @RequestMapping("/add_new")
    public ModelAndView addNew(@RequestParam(value = "task") String task) throws IOException {
        Task todo = new Task();
        todo.setTask(task);
        todo.setStatus(Status.OPEN);
        taskService.addTask(todo);
        return new ModelAndView(new RedirectView("/list", true));
    }

    @RequestMapping("/delete")
    public ModelAndView deleteTask(@RequestParam(value = "id") Integer id) throws IOException {
        taskService.deleteTask(id);
        return new ModelAndView(new RedirectView("/list", true));
    }

    @RequestMapping("/editStatus")
    public ModelAndView editTaskStatus(@RequestParam(value = "id") Integer id,
                                       @RequestParam(value = "status") Status status) {
        System.out.println(status);
        System.out.println(id);
        taskService.editTaskStatus(id, status);
        return new ModelAndView(new RedirectView("/list", true));
    }
}
