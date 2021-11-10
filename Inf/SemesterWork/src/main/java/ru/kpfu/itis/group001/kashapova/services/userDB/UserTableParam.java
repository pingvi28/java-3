package ru.kpfu.itis.group001.kashapova.services.userDB;

import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * возращение небходимых полей из user_lamp_corner
 */

public class UserTableParam extends UserTableConnect {

    public static String returnStringParam(int user_id, String columnName){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return ""; //нет пользователя
            return rs.getString(columnName);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UDBP#returnStringParam " + columnName + ":" + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }

    public static boolean returnConfirmFlag(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return false; //нет пользователя
            return rs.getBoolean("email_confirmed");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UDBP#returnConfirmFlag :" + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
