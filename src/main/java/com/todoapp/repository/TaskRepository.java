package com.todoapp.repository;

import com.todoapp.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
