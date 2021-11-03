package ru.kpfu.itis.group001.kashapova.java_class.userDB;

import java.sql.*;

public class UserDBParam extends UserConnnect{

    public static String returnStringParam(int user_id, String columnName){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return ""; //нет пользователя
            return rs.getString(columnName);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UDBP#return " + columnName + ":" + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }
}
