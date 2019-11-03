package com.example.demo.api;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.UserProfile;


@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @RequestMapping("/signup")
    Response signup(UserProfile profileRequest) {
        return Response.ok().build();
    }

    @RequestMapping("/login")
    Response login(LoginRequest loginRequest) {
        if(!StringUtils.isEmpty(loginRequest.getUsername()) && !StringUtils.isEmpty(loginRequest.getPassword())) {

        }
        return Response.ok().build();
    }
}
