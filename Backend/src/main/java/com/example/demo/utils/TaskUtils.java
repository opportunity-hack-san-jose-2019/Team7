package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.example.demo.model.Tags;
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
            if(!StringUtils.isEmpty(taskJson)) {
                Task task = mapper.readValue(taskJson, Task.class);
                tasks.add(task);
            }
        }

        return tasks;
    }

    public static boolean filter(Task task, TaskFilter filter) {
        if((filter.getRequestCategory() == null || filter.getRequestCategory().equals(task.getRequestCategory()))
                && (filter.getSubcategory() == null || filter.getSubcategory().equals(task.getSubcategory()))
                && (filter.getRequestorId() == null || filter.getRequestorId().equals(task.getRequestorId()))
                && (filter.getVolunteerId() == null || filter.getVolunteerId().equals(task.getVolunteerId()))
                && (filter.isFinished() == null || filter.isFinished().equals(task.isFinished()))) {
            return false;
        } else {
            return true;
        }
    }

    public static List<Task> sortTasks(final Tags tags, final List<Task> taskList) {
        List<Task> preferred = new ArrayList<>();
        List<Task> other = new ArrayList<>();

        for(Task task: taskList) {
            if(tags.getCategories().contains(task.getRequestCategory())
                    && tags.getSubcategories().contains(task.getSubcategory())) {
                preferred.add(task);
            } else {
                other.add(task);
            }
        }

        preferred.addAll(other);
        return preferred;
    }
}
