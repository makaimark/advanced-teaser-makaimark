package com.todoapp.service;

import com.todoapp.Task;
import com.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> listAllTask() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.delete(id);
    }
}
