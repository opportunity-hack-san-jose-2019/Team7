package com.example.demo.model;

public class Task extends TaskRequest {

    String taskId;

    String volunteerId;

    int priority; // higher the number, more the priority.

    boolean isFinished;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(final String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(final boolean finished) {
        isFinished = finished;
    }
}
