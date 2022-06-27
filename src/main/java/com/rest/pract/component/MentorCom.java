package com.rest.pract.component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rest.pract.models.Mentor;
import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class MentorCom {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public MentorCom() {
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

    //Фукнция на добавление записи
    public static void save(com.rest.pract.models.Mentor mentor) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO mentor(firstname,lastname,patronymic) VALUES(?,?,?)");

            preparedStatement.setString(1, mentor.getFirstname());
            preparedStatement.setString(2, mentor.getLastname());
            preparedStatement.setString(3, mentor.getPatronimic());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }
    //поиск по id
    public static Mentor show(int id) {
        Mentor mentor = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM mentor WHERE idmentor=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            mentor = new Mentor();
            mentor.setIdmentor(resultSet.getInt("idmentor"));
            mentor.setFirstname(resultSet.getString("firstname"));
            mentor.setLastname(resultSet.getString("lastname"));
            mentor.setPatronimic(resultSet.getString("patronymic"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return mentor;
    }

    public static String delete(int id) {
        try {
            PreparedStatement prepared_statement = connection.prepareStatement("DELETE FROM mentor WHERE idmentor= ? ;");
            prepared_statement.setInt(1, id);
            int result_set = prepared_statement.executeUpdate();
            if (result_set > 0)
            {
                return "deleted";
            }
            else
            {
                return "cant delete";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return " ";
    }

    public static List<Mentor> index() {
        List<Mentor> mentors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM mentor";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Mentor mentor = new Mentor();

                mentor.setIdmentor(resultSet.getInt("idmentor"));
                mentor.setFirstname(resultSet.getString("firstname"));
                mentor.setLastname(resultSet.getString("lastname"));
                mentor.setPatronimic(resultSet.getString("patronymic"));
                System.out.println(mentor);
                mentors.add(mentor);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(mentors);
        return mentors;
    }

}
