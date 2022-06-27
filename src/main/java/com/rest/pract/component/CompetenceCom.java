package com.rest.pract.component;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.pract.models.Competence;
import com.rest.pract.models.Student;

@Component
public class CompetenceCom {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public CompetenceCom() {
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void save(Competence competence) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO competence(name,value) VALUES(?,?)");

            preparedStatement.setString(1, competence.getName());
            preparedStatement.setString(2, competence.getValue());
            
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

}
