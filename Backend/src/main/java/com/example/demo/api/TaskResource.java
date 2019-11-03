package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dal.UserDao;
import com.example.demo.model.Tags;
import com.example.demo.model.Task;
import com.example.demo.model.TaskFilter;
import com.example.demo.model.Tasks;
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
            FileUtils.persistData(Constants.taskFileName, json);

            UserResponse response = new UserResponse();
            response.setUserId(taskRequest.getRequestorId());

            return Response.ok(response).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/getall")
    @PostMapping
    Response getTasks(@RequestBody TaskFilter filterRequest) {

        List<Task> tasks = new ArrayList<>();
        try {
            List<Task> allTasks = TaskUtils.getTasks();
            for(Task task: allTasks) {
                if(!TaskUtils.filter(task, filterRequest)) {
                    tasks.add(task);
                }
            }

            Tasks taskResponse = new Tasks();
            taskResponse.setTasks(tasks);
            //todo: sort by category and subcategory (preferred once are on top).
            return Response.ok(taskResponse).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    private List<Task> sortTasks(final Tags tags, final List<Task> taskList) {
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
