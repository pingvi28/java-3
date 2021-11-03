package ru.kpfu.itis.group001.kashapova.java_class.userDB;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;
import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.MyHash;

import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class ChangerUserDB extends UserConnnect{
    /**
     * проверка при входе на сайт
     * @param email
     * @param password
     * @return
     */
    public int validate(String email, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where email='" + email + "';");
            if (!rs.next()) return -1; //нет email
            // если пользователь есть
            password = String.valueOf(MyHash.createHashPassword(password));
            if (rs.getString("hash").equals(password))
                return rs.getInt("id");
            else return -2;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CUDB#validate em/pass) " + e.getMessage() + " : " + e.getCause());
            return -3;
        }
    }

    /**
     * проверка на наличие пользователя при регистрации
     * @param email
     * @return
     */
    public boolean validate(String email) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where email='" + email + "';");
            if (!rs.next()) return false;
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CUDB#validate em) " + e.getMessage() + " : " + e.getCause());
            return false;
        } finally {
            try { connection.close(); } catch(SQLException se) {  }
        }
    }

    /**
     * добавление пользователя в бд и формирование токена
     * @param name
     * @param surname
     * @param email
     * @param password
     * @return
     */
    public int add(String name, String surname, String email, String password) {
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement statement = connection.prepareStatement(
                     "insert into " + tableWithUser + " (name ,surname, email, hash) values (? ,? ,?, ?) returning id;")) {
            //заранее экранирует значение
            Class.forName("org.postgresql.Driver");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, String.valueOf(MyHash.createHashPassword(password)));
            ResultSet rs = statement.executeQuery();
            rs.next();
            UserTokenEmail.createToken(rs.getInt(1),email);
            return rs.getInt(1);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CUDB#add) " + e.getMessage() + " : " + e.getCause());
            return -1;
        } finally {
            try { connection.close(); } catch(SQLException se) {  }
        }
    }

    public static boolean updateProfileNS(int user_id, String changedName, String changedSurname){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return false; //нет пользователя

            rs = statement.executeQuery("update " + tableWithUser +" set name = " + changedName + " where id= " + user_id +";"+
                                            "update " + tableWithUser + " set surname = " + changedSurname + " where id= " + user_id +";");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CUDB#updateProfileNS) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }

    public static boolean updateProfilePass(int user_id, String password){
        try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            ResultSet rs = statement.executeQuery("select * from " + tableWithUser + " where id=" + user_id +";");
            if (!rs.next()) return false; //нет пользователя

            rs = statement.executeQuery("update " + tableWithUser +" set hash =" + String.valueOf(MyHash.createHashPassword(password)) +
                     " where id= " + user_id +";");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(CUDB#updateProfilePass) " + e.getMessage() + " : " + e.getCause());
            return false;
        }
    }
}



