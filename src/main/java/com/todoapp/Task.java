package com.todoapp;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String task;
    public String status;

//    public Task(String task, String status) {
//        this.task = task;
//        this.status = status;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}