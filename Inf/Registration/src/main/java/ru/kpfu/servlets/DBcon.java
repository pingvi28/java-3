package ru.kpfu.servlets;


import java.sql.*;

public class DBcon {
    private static Connection connection;
    protected static Statement statement;
    private static final String url = "jdbc:postgresql://rc1c-edkx6axwh3chvb4k.mdb.yandexcloud.net:6432/Registration_user";
    private static final String user = "Di";
    private static final String passwordDB = "1234567890";
    private static final String table = "user_login";

    public DBcon() {
        connect();
    }

    public static void connect() {
        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, passwordDB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int validate(String email, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + table + " where email='" + email + "';");
            if (!rs.next()) return -1;
            // если пользователь есть
            if (rs.getString("password").equals(password))
                return rs.getInt("id");
            else return -1;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UL#validate) " + e.getMessage() + " : " + e.getCause());
            return -1;
        }
    }
    public boolean validate(String email) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + table + " where email='" + email + "';");
            if (!rs.next()) return false;
            // если пользователь есть
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UL#validate) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public int add(String name, String surname, String email, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "insert into " + table + " (name ,surname, email, password) values (? ,? ,?, ?) returning id;")) {
            //заранее экранирует значение
            Class.forName("org.postgresql.Driver");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UL#add) " + e.getMessage() + " : " + e.getCause());
            return -1;
        }
    }

}


