package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Task;
import com.example.demo.model.TaskRequest;
import com.example.demo.model.UserProfile;


@RestController
@RequestMapping(path = "/task")
public class ActionResource {

    @RequestMapping("/")
    @PostMapping
    Response addTask(TaskRequest taskRequest) {

        // get the request , map to task object -> write to txt or DB file
        return Response.ok().build();
    }

    @RequestMapping("/")
    @GetMapping
    Response getAllTasks(Boolean isActive) {

        List<Task> tasks = new ArrayList<>();

        // read the tasks from task.txt or DB , parse csv,populate the response object
    }
}
