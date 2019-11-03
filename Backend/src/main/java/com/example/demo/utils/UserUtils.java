package com.example.demo.utils;

import java.io.IOException;
import java.util.List;
import com.example.demo.model.UserPreferences;
import com.example.demo.model.UserProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserUtils {

    public static ObjectMapper mapper = new ObjectMapper();

    public static UserProfile getUser(String userId, String emailId) throws JsonProcessingException {
        List<String> users = FileUtils.readData(Constants.userFileName);

        for(String userJson : users) {
            UserProfile userProfile = mapper.readValue(userJson, UserProfile.class);
            if(userProfile.getUserId().equals(userId)
                    || userProfile.getEmail() != null
                    && userProfile.getEmail().equalsIgnoreCase(emailId)) {
                return userProfile;
            }
        }

        return null;
    }

    public static UserPreferences getUserPreference(String userId) throws JsonProcessingException {
        List<String> preferences = FileUtils.readData(Constants.preferencesFileName);

        for(String preferencesJson : preferences) {
            UserPreferences userPreference = mapper.readValue(preferencesJson, UserPreferences.class);
            if(userPreference.getUserId().equals(userId)) {
                return userPreference;
            }
        }
        return null;
    }
}
