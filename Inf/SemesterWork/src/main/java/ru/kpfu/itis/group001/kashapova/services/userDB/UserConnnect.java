package ru.kpfu.itis.group001.kashapova.services.userDB;

import properties.DBproperties;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class UserConnnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableWithUser;

    /**
     * конструктор для присваивания параметров бд и установления связи
     */
    public UserConnnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableWithUser = DBproperties.tableUserLampCorner;
    }


}
