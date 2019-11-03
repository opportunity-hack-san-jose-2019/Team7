package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Task;
import com.example.demo.model.TaskFilter;
import com.example.demo.model.UserProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TaskUtils {

    public static ObjectMapper mapper = new ObjectMapper();

    public static List<Task> getTasks() throws JsonProcessingException {
        List<String> taskJsons = FileUtils.readData(Constants.taskFileName);

        List<Task> tasks = new ArrayList<>();

        for(String taskJson : taskJsons) {
            Task task = mapper.readValue(taskJson, Task.class);
            tasks.add(task);
        }

        return tasks;
    }

    public static boolean filter(Task task, TaskFilter filter) {
        if(filter.getRequestCategory() == null || filter.getRequestCategory().equals(task.getRequestCategory())
                && filter.getSubcategory() == null || filter.getSubcategory().equals(task.getSubcategory())
                && filter.getRequestorId() == null || filter.getRequestorId().equals(task.getRequestorId())
                && filter.getVolunteerId() == null || filter.getVolunteerId().equals(task.getVolunteerId())
                && filter.isFinished() == null || filter.getVolunteerId().equals(task.getVolunteerId())) {
            return false;
        } else {
            return true;
        }
    }

    public static List<Task> sortTasks(List<Task> tasks) {

        for(Task task: tasks) {
            if(task.getSubcategory().equals(Constants.Emergency_Relief)) {
                task.setPriority(Integer.MAX_VALUE);
            } else if()
        }
    }
}
