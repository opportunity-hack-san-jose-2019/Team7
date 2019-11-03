package com.example.demo;

import org.junit.jupiter.api.Test;
import com.example.demo.model.UserProfile;
import com.example.demo.utils.FileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ActionutilsTest {

    @Test
    public void testFileWrite(){
        boolean result= FileUtils.persistData("Task","testdata");
    }

    @Test
    public void testFileRead(){
       FileUtils.readData("Task");
    }

    @Test
    public void test() throws JsonProcessingException {
        UserProfile profile = new UserProfile();
        System.out.println(new ObjectMapper().writeValueAsString(profile));
    }
}
