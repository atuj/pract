package com.rest.pract.component;

import java.io.Console;
import java.sql.*;

import org.springframework.stereotype.Component;

import com.rest.pract.models.Student;

@Component
public class StudentCom {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public StudentCom() {
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


    public static void save(Student student) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO student(firstname,lastname,patronimic,dateofbirth,gender,city,email,phone,id_university,id_statement) VALUES(?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, student.getFirstname());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setString(3, student.getPatronimic());
            preparedStatement.setDate(4, student.getDateofbirth());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setString(6, student.getCity());
            preparedStatement.setString(7, student.getEmail());
            preparedStatement.setString(8, student.getPhone());
            preparedStatement.setInt(9, student.getId_university());
            preparedStatement.setInt(10, student.getId_statement());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

}