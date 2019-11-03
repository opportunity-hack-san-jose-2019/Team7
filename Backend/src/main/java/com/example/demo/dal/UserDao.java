package com.example.demo.dal;

import java.sql.Connection;
import java.sql.SQLException;
import com.example.demo.model.UserProfile;


public class UserDao {

    public void createRecord(UserProfile profile) {
        try {
            Connection connection = DatabaseConnector.getConnector().getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
