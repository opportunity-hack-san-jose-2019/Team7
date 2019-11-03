package com.example.demo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Tasks {

    @JsonProperty("tasks")
    List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }
}
