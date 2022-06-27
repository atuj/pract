package com.rest.pract.component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rest.pract.models.DirectionPractic;
import com.rest.pract.models.Mentor;
import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class DirectionPracticCom {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public DirectionPracticCom() {
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
    public static void save(com.rest.pract.models.DirectionPractic directionPractic) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO directionpractic(name,description,id_program) VALUES(?,?,?)");

            preparedStatement.setString(1, directionPractic.getName());
            preparedStatement.setString(2, directionPractic.getDescription());
            preparedStatement.setInt(3, directionPractic.getId_program());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

    public static String delete(int id) {
        try {
            PreparedStatement prepared_statement = connection.prepareStatement("DELETE FROM directionpractic WHERE iddirection= ? ;");
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

    public static List<DirectionPractic> index() {
        List<DirectionPractic> directionPractics = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM directionpractic";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                DirectionPractic directionPractic = new DirectionPractic();

                directionPractic.setIddirection(resultSet.getInt("iddirection"));
                directionPractic.setName(resultSet.getString("name"));
                directionPractic.setDescription(resultSet.getString("description"));
                directionPractic.setId_program(resultSet.getInt("id_program"));
                System.out.println(directionPractic);
                directionPractics.add(directionPractic);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(directionPractics);
        return directionPractics;
    }

}
