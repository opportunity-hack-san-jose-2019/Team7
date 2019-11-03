package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Task;


public class Utils {

    public static List<Task> getDummyTasks() {
        List<Task> taskList = new ArrayList<>();

        Task task1 = new Task();
        task1.setRequestorId("dummy_requester");
        taskList.add(task1);

        return taskList;
    }
}
