package com.rest.pract.component;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rest.pract.models.Mentor;
import com.rest.pract.models.PracticMentor;

import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class PracticMentorCom {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public PracticMentorCom() {
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



    public static void save(PracticMentor practicMentor) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO practic_mentor(id_mentor,id_practice) VALUES(?,?)");

            preparedStatement.setInt(1, practicMentor.getId_mentor());
            preparedStatement.setInt(2, practicMentor.getId_practice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }


    public static void update(int id, PracticMentor practicMentor) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE practic_mentor SET id_mentor=?  WHERE id_practice=?");

                    preparedStatement.setInt(1, practicMentor.getId_mentor());
                    preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
