package ru.kpfu.itis.group001.kashapova.java_class.confirmDB;

import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.MyHash;

import java.util.Date;
import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * при регистрации формируется токен, который записывается в отдельную таблицу
 */

public class UserTokenEmail extends ConfirmUsersConnect {

    public static void createToken( int userID,String email) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
                PreparedStatement statement = connection.prepareStatement(
                     "insert into " + tableConfirmUsers + " (user_id, token, data_registration) values (? ,? ,?) returning id;")) {
            Class.forName("org.postgresql.Driver");
            Date date = new Date();
            statement.setInt(1, userID);
            statement.setString(2, String.valueOf(MyHash.createHashPassword(email)));
            statement.setString(3, date.toString());
            ResultSet rs = statement.executeQuery();
            rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTE#createToken) " + e.getMessage() + " : " + e.getCause());
        }
    }

    public static String returnToken(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableConfirmUsers + " where user_id=" + user_id +";");

            if (!rs.next()) return ""; //нет пользователя
            return rs.getString("token");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTE#returnToken) " + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }

    public static boolean updateToken(int userID,String email){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableConfirmUsers + " where id=" + userID +";");

            if (!rs.next()) return false; //нет пользователя

            rs = statement.executeQuery("update " + tableConfirmUsers + " set token = " + MyHash.createHashPassword(email) + "where id= " + userID +";");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTE#updateToken) " + e.getMessage() + " : " + e.getCause());
            return false;
        }

    }
}
