package ru.kpfu.itis.group001.kashapova.services.userDB;

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
    public static boolean returnConfirmFlag(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return false; //нет пользователя
            return rs.getBoolean("email_confirmed");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UDBP#returnFlag :" + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
