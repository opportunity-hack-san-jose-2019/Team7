package com.example.demo.api;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.TaskRequest;
import com.example.demo.model.UserProfile;


@RestController
@RequestMapping(path = "/action")
public class ActionResource {

    @RequestMapping("/findhelp")
    Response addTask(TaskRequest taskRequest) {


        // TODO: this API adds task to DB
        return Response.ok().build();
    }

    @RequestMapping("/match")
    Response requestHelp(MatchRequest matchRequest) {
        // todo: this api will match volunteers with a given person.
        return Response.ok().build();
    }
}
