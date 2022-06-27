package com.rest.pract.component;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

     //поиск по id
     public static Student show(int id) {
        Student student = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM student WHERE idstudent=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            student = new Student();

            student.setIdstudent(resultSet.getInt("idstudent"));
            student.setFirstname(resultSet.getString("firstname"));
            student.setLastname(resultSet.getString("lastname"));
            student.setPatronimic(resultSet.getString("patronimic"));
            student.setDateofbirth(resultSet.getDate("dateofbirth"));
            student.setGender(resultSet.getString("gender"));
            student.setCity(resultSet.getString("city"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));
            student.setId_university(resultSet.getInt("id_university"));
            student.setId_statement(resultSet.getInt("id_statement"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    public static List<Student> index() {
        List<Student> temp = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Student student = new Student();

                student.setIdstudent(resultSet.getInt("idstudent"));
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setPatronimic(resultSet.getString("patronimic"));
                student.setDateofbirth(resultSet.getDate("dateofbirth"));
                student.setGender(resultSet.getString("gender"));
                student.setCity(resultSet.getString("city"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setId_university(resultSet.getInt("id_university"));
                student.setId_statement(resultSet.getInt("id_statement"));

            temp.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }

    public static void update(int id, Student updatedStudent) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE student SET firstname=?,lastname=?,patronimic=?,dateofbirth=?,gender=?,city=?,email=?,phone=?,id_university=?,id_statement=? WHERE idstudent=?");

                    preparedStatement.setString(1, updatedStudent.getFirstname());
                    preparedStatement.setString(2, updatedStudent.getLastname());
                    preparedStatement.setString(3, updatedStudent.getPatronimic());
                    preparedStatement.setDate(4, updatedStudent.getDateofbirth());
                    preparedStatement.setString(5, updatedStudent.getGender());
                    preparedStatement.setString(6, updatedStudent.getCity());
                    preparedStatement.setString(7, updatedStudent.getEmail());
                    preparedStatement.setString(8, updatedStudent.getPhone());
                    preparedStatement.setInt(9, updatedStudent.getId_university());
                    preparedStatement.setInt(10, updatedStudent.getId_statement());
                    preparedStatement.setInt(11, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(int id) {
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM student WHERE idstudent=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }}


}