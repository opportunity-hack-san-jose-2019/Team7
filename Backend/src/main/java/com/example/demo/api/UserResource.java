package com.example.demo.api;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserProfile;


@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @RequestMapping("/signup")
    @PostMapping
    Response signup(UserProfile profileRequest) {

    }

    @RequestMapping("/login")
    @PostMapping
    Response login(LoginRequest loginRequest) {

    }
}
