package com.todoapp.database.implementation;

import com.todoapp.Status;
import com.todoapp.Task;
import com.todoapp.database.dao.TaskServiceDao;
import com.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceDao{

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> listAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.delete(id);
    }

    @Override
    public void editTaskStatus(Integer id, Status status) {
        Task task = taskRepository.findOne(id);
        task.setStatus(status);
        taskRepository.save(task);
    }
}
