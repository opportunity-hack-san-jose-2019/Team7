package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dal.UserDao;
import com.example.demo.model.Tags;
import com.example.demo.model.Task;
import com.example.demo.model.TaskFilter;
import com.example.demo.model.Tasks;
import com.example.demo.model.UserPreferences;
import com.example.demo.model.UserProfile;
import com.example.demo.model.UserResponse;
import com.example.demo.utils.Constants;
import com.example.demo.utils.FileUtils;
import com.example.demo.utils.TaskUtils;
import com.example.demo.utils.UserUtils;
import com.example.demo.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(path = "/task")
public class TaskResource {

    @Inject
    UserDao userDao;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/add")
    @PostMapping
    Response addTask(@RequestBody Task taskRequest) {

        try {
            UserProfile profile = UserUtils.getUser(taskRequest.getRequestorId(), null);

            if(profile == null) {
                return Response.status(404).build();
            }

            taskRequest.setTaskId(new Random().nextInt(999999999)+"");
            taskRequest.setFinished(false);

            String json = mapper.writeValueAsString(taskRequest);
            FileUtils.persistData(Constants.taskFileName, json, true);

            UserResponse response = new UserResponse();
            response.setUserId(taskRequest.getRequestorId());

            return Response.ok(response).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/update")
    @PostMapping
    Response updateTask(@RequestBody Task taskRequest) {

        try {
            UserProfile profile = UserUtils.getUser(taskRequest.getVolunteerId(), null);

            if(profile == null) {
                return Response.status(404).build();
            }

            List<Task> allTasks = TaskUtils.getTasks();
            String dbRecords = "";
            for(Task task: allTasks) {
                if(task.getTaskId().equals(taskRequest.getTaskId())) {
                    task.setVolunteerId(taskRequest.getVolunteerId());
                }
                String json = mapper.writeValueAsString(taskRequest);
                dbRecords = json + "\n" + dbRecords;
            }

            FileUtils.persistData(Constants.taskFileName, dbRecords, false);

            UserResponse response = new UserResponse();
            response.setUserId(taskRequest.getRequestorId());

            return Response.ok(response).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/delete")
    @GetMapping
    Response deleteTask(@RequestParam("task_id") String taskId) {

        try {
            List<Task> allTasks = TaskUtils.getTasks();
            String dbRecords = "";
            for(Task task: allTasks) {
                if(!task.getTaskId().equals(taskId)) {
                    String json = mapper.writeValueAsString(task);
                    dbRecords = json + "\n" + dbRecords;
                }
            }

            FileUtils.persistData(Constants.taskFileName, dbRecords, false);

            return Response.ok().build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/getall")
    @PostMapping
    Response getTasks(@RequestBody TaskFilter filterRequest) {


        try {
            List<Task> tasks = new ArrayList<>();
            List<Task> allTasks = TaskUtils.getTasks();
            for(Task task: allTasks) {
                if(!TaskUtils.filter(task, filterRequest)) {
                    tasks.add(task);
                }
            }

            if(filterRequest.getRequestorId() != null) {
                UserPreferences preferences = UserUtils.getUserPreference(filterRequest.getRequestorId());
                tasks = TaskUtils.sortTasks(preferences.getTags(), tasks);
            } else if(filterRequest.getVolunteerId() != null) {
                UserPreferences preferences = UserUtils.getUserPreference(filterRequest.getVolunteerId());
                tasks = TaskUtils.sortTasks(preferences.getTags(), tasks);
            }

            Tasks taskResponse = new Tasks();
            taskResponse.setTasks(tasks);

            return Response.ok(taskResponse).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }
}
