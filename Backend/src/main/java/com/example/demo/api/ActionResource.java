package com.example.demo.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dal.UserDao;
import com.example.demo.model.Tags;
import com.example.demo.model.Task;
import com.example.demo.model.TaskRequest;
import com.example.demo.model.Tasks;
import com.example.demo.model.UserProfile;
import com.example.demo.utils.Utils;


@RestController
@RequestMapping(path = "/task")
public class ActionResource {

    @Inject
    UserDao userDao;

    @RequestMapping("/add")
    @PostMapping
    Response addTask(TaskRequest taskRequest) {
        // get the request , map to task object -> write to txt or DB file
        return Response.ok().build();
    }

    @RequestMapping("/getall")
    @GetMapping
    Response getAllTasks(
            @QueryParam("volunteer_id") String volunteerId,
            @QueryParam("category") String category,
            @QueryParam("subcategory") String subcategory) {

        // read the tasks from task.txt or DB , parse csv,populate the response object
        List<Task> taskList = Utils.getDummyTasks();
        // match with volunteer id
        if(volunteerId != null) {
            Tags tags = userDao.getVolunteerInterests(volunteerId);
            taskList = sortTasks(tags, taskList);
        }

        Tasks taskResponse = new Tasks();
        taskResponse.setTasks(taskList);

        // sort by category and subcategory (preferred once are on top).
        return Response.ok(taskResponse).build();
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
