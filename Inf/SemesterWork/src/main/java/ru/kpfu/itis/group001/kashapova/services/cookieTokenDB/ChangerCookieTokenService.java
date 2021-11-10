package ru.kpfu.itis.group001.kashapova.services.cookieTokenDB;

import ru.kpfu.itis.group001.kashapova.java_class.MyHash;

import java.sql.*;

public class ChangerCookieTokenService extends CookieTokenDBConnect {
    public static String add(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "insert into " + tableWithUserCookieID + " (user_id,cook_token) values (? ,?) returning user_id;")) {
            //заранее экранирует значение
            Class.forName("org.postgresql.Driver");
            statement.setInt(1, id);
            statement.setString(2,String.valueOf(MyHash.createHashPassword(String.valueOf(id))));

            ResultSet rs = statement.executeQuery();
            rs.next();
            return returnToken(rs.getInt(1));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CCTS#add) " + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }

    public static String returnToken(int id){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUserCookieID + " where user_id=" +  id +";");
            if (!rs.next()) return "";
            return rs.getString("cook_token");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CCTS#return token " + ":" + e.getMessage() + " : " + e.getCause());
            return "";
        }
    }

    public static int returnUserID(String cookieToken){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUserCookieID + " where cook_token=\'" +  cookieToken +"\';");
            if (!rs.next()) return -1; //нет пользователя
            return rs.getInt("user_id");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CCTS#return user_id " + ":" + e.getMessage() + " : " + e.getCause());
            return -1;
        }
    }

    public static boolean deleteProfile(int user_id){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "delete from " + tableWithUserCookieID + " where user_id= ? ;")) {
            //заранее экранирует значение
            Class.forName("org.postgresql.Driver");
            statement.setInt(1, user_id);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CCTS#deleteProfile) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}
