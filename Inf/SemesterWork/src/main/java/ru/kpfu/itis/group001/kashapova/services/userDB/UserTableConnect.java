package ru.kpfu.itis.group001.kashapova.services.userDB;

import properties.DBproperties;
import ru.kpfu.itis.group001.kashapova.services.confirmDB.ConfirmUsersTableConnect;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.CookieTokenTableConnect;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 *  конструктор для присваивания параметров бд и установления связи с user_lamp_corner
 */

public class UserTableConnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String password;
    protected static String tableWithUser;

    public UserTableConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        password = DBproperties.passwordDB;
        tableWithUser = DBproperties.tableUserLampCorner;

        cookieTokenDBConnect();
        confirmUsersDBConnect();
    }

    public void cookieTokenDBConnect(){
        CookieTokenTableConnect cookieToken = new CookieTokenTableConnect();
    }

    public void confirmUsersDBConnect(){
        ConfirmUsersTableConnect confirmUsersConnect = new ConfirmUsersTableConnect();
    }
}
