package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}
