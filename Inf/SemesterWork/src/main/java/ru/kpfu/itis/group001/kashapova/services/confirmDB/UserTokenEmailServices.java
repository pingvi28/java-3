package ru.kpfu.itis.group001.kashapova.services.confirmDB;

import ru.kpfu.itis.group001.kashapova.java_class.MyHash;

import java.util.Date;
import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * при регистрации формируется токен (email), который записывается в отдельную таблицу
 */

public class UserTokenEmailServices extends ConfirmUsersTableConnect {
    /**
     * формирует токен для проверки почты
     * @param userID
     * @param email
     */
    public static void createToken( int userID,String email) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
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
            System.out.println("(UTES#createToken) " + e.getMessage() + " : " + e.getCause());
        }
    }

    public static String returnToken(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableConfirmUsers + " where user_id=" + user_id +";");

            if (!rs.next()) return ""; //нет пользователя
            return rs.getString("token");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTES#returnToken) " + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }

    public static boolean deleteProfile(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(
                     "delete from " + tableConfirmUsers + " where user_id= ? ;")) {
            //заранее экранирует значение
            Class.forName("org.postgresql.Driver");
            statement.setInt(1, user_id);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTES#deleteProfile) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
