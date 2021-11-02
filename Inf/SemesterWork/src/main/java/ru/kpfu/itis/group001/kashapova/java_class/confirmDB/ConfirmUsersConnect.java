package ru.kpfu.itis.group001.kashapova.java_class.confirmDB;

import properties.DBproperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class ConfirmUsersConnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableConfirmUsers;

    public ConfirmUsersConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableConfirmUsers = DBproperties.tableConfirmUsers;
        connect();
    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, passwordDB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("(UTE#connect) " + e.getMessage() + " : " + e.getCause());
        }
    }
}
