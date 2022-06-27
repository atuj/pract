package com.rest.pract.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.rest.pract.models.PracticeStatus;

@Component
public class PracticeStatusCom {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public PracticeStatusCom() {
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



    public static void save(PracticeStatus practiceStatus) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO practicestatus(description,assessment,value) VALUES(?,?,?)");

            preparedStatement.setString(1, practiceStatus.getDescription());
            preparedStatement.setString(2, practiceStatus.getAssessment());
            preparedStatement.setString(3, practiceStatus.getValue());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

    public static void update(int id, PracticeStatus practiceStatus) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE practicestatus SET description=?,assessment=?,value=? WHERE idstatus=?");

                    preparedStatement.setString(1, practiceStatus.getDescription());
                    preparedStatement.setString(2, practiceStatus.getAssessment());
                    preparedStatement.setString(3, practiceStatus.getValue());
                    preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
