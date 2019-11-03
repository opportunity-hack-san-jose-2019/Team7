package com.example.demo.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Response;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.UserPreferences;
import com.example.demo.model.UserProfile;
import com.example.demo.model.UserResponse;
import com.example.demo.utils.Constants;
import com.example.demo.utils.FileUtils;
import com.example.demo.utils.UserUtils;
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
            FileUtils.persistData(Constants.userFileName, json, true);

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

        try {
            UserProfile profile = UserUtils.getUser(null, loginRequest.getUsername());

            if(profile == null) {
                return Response.status(404).build();
            }

            UserResponse response = new UserResponse();
            response.setUserId(profile.getUserId());

            return Response.ok(response).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/getall")
    @GetMapping
    Response getAll() {

        List<UserProfile> users = new ArrayList<>();

        try {
            List<String> userJsons = FileUtils.readData(Constants.userFileName);
            for(String userJson: userJsons) {
                users.add(mapper.readValue(userJson, UserProfile.class));
            }
            return Response.ok(users).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/preferences")
    @PostMapping
    Response preferences(@RequestBody UserPreferences preferences) {

        try {
            UserProfile profile = UserUtils.getUser(preferences.getUserId(), null);

            if(profile == null) {
                return Response.status(404).build();
            }

            String json = mapper.writeValueAsString(preferences);
            FileUtils.persistData(Constants.preferencesFileName, json, true);

            UserResponse response = new UserResponse();
            response.setUserId(profile.getUserId());

            return Response.ok(response).build();

        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }

    @RequestMapping("/upload")
    @PostMapping
    Response upload(@RequestBody MultipartFile file) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);

            for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
                XSSFRow row = worksheet.getRow(i);

                UserProfile profile = new UserProfile();
                profile.setFirstName(row.getCell(0).getStringCellValue());
                profile.setLastName(row.getCell(1).getStringCellValue());
                profile.setPhoneNumber(row.getCell(2).getStringCellValue());
                profile.setEmail(row.getCell(3).getStringCellValue());
                profile.setAddress(row.getCell(4).getStringCellValue());
                profile.setCity(row.getCell(5).getStringCellValue());
                profile.setState(row.getCell(6).getStringCellValue());
                profile.setZipcode(row.getCell(7).getStringCellValue());
                profile.setUserId(new Random().nextInt(999999999)+"");

                String json = mapper.writeValueAsString(profile);
                FileUtils.persistData(Constants.userFileName, json, true);
            }
            return Response.ok().build();
        } catch (IOException e) {
            return Response.serverError().build();
        }
    }
}
