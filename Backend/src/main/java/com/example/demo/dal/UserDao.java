package com.example.demo.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.example.demo.model.Tags;
import com.example.demo.model.UserProfile;

@Component
public class UserDao {

    public void createRecord(UserProfile profile) {
        try {
            Connection connection = DatabaseConnector.getConnector().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tags getVolunteerInterests(String volunteerId) {
        Tags tags = new Tags();
        tags.setCategories(new ArrayList<>());
        tags.setSubcategories(new ArrayList<>());

        tags.getCategories().add("disaster_relief");
        tags.getSubcategories().add("education");

        return tags;
    }
}
