package com.example.demo.api;

import java.util.Random;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserProfile;
import com.example.demo.model.UserResponse;
import com.example.demo.utils.Constants;
import com.example.demo.utils.FileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(path = "/user")
public class UserResource {

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/signup")
    @PostMapping
    Response signup(@RequestBody UserProfile profileRequest) {

        profileRequest.setUserId(new Random().nextInt(999999999)+"");
        try {
            String json = mapper.writeValueAsString(profileRequest);
            FileUtils.persistData(Constants.userFileName, json);

            UserResponse response = new UserResponse();
            response.setUserId(profileRequest.getUserId());

            return Response.ok(response).build();
        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/login")
    @PostMapping
    Response login(@RequestBody LoginRequest loginRequest) {



        return Response.ok().build();
    }
}
