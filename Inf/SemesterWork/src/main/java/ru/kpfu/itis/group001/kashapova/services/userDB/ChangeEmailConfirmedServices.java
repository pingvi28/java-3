package ru.kpfu.itis.group001.kashapova.services.userDB;

import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * изменение/работа с таблицей - user_lamp_corner
 */

public class ChangeEmailConfirmedServices extends UserTableConnect {

    public static boolean changeEmailConfirmed(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");

            if (!rs.next()) return false; //нет пользователя
            if (!rs.getBoolean("email_confirmed")){
                rs = statement.executeQuery("update " + tableWithUser +" set email_confirmed = true  where id= " + user_id +";");
            }
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CECS#changeEmailConfirmed) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
