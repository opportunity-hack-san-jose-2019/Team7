package com.example.demo;

import javax.swing.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.api.ActionUtils;


public class ActionutilsTest {

    @Test
    public void testFileWrite(){
        boolean result= ActionUtils.persistData("Task","testdata");


    }

    @Test
    public void testFileRead(){
       ActionUtils.readData("Task");


    }

}
