package com.todoapp.database.dao;

import com.todoapp.Task;

public interface TaskServiceDao {

    Iterable<Task> listAllTask();

    void addTask(Task task);

    void deleteTask(Integer id);

}
