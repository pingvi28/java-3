package ru.kpfu.itis.group001.kashapova.services.cookieTokenDB;

import properties.DBproperties;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class CookieTokenDB {
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableWithUserCookieID;

    /**
     * конструктор для присваивания параметров бд и установления связи
     */
    public CookieTokenDB() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableWithUserCookieID = DBproperties.tableCooke;
    }


}