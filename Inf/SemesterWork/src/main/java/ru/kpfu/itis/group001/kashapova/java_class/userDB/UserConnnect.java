package ru.kpfu.itis.group001.kashapova.java_class.userDB;

import properties.DBproperties;
import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserConnnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableWithUser;
    protected static UserTokenEmail userTokenEmail = new UserTokenEmail();

    /**
     * конструктор для присваивания параметров бд и установления связи
     */
    public UserConnnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableWithUser = DBproperties.tableUserLampCorner;
        connect();
    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, passwordDB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("(UDB#connect) " + e.getMessage() + " : " + e.getCause());
        }
    }
}
