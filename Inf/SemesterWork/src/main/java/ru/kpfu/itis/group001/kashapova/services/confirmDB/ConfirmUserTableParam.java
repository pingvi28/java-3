package ru.kpfu.itis.group001.kashapova.services.confirmDB;

import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * возращение необходимых данных из ConfirmUsersDB
 */
public class ConfirmUserTableParam extends ConfirmUsersTableConnect {
    public static String returnDataRegistration(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableConfirmUsers + " where user_id=" + user_id +";");

            if (!rs.next()) return ""; //нет пользователя
            return rs.getString("data_registration");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(UTE#returnDataRegistration) " + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }
}
