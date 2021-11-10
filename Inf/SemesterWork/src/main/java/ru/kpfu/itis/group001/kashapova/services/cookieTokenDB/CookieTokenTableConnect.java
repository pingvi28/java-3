package ru.kpfu.itis.group001.kashapova.services.cookieTokenDB;

import properties.DBproperties;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 *  конструктор для присваивания параметров бд и установления связи с cookie_token
 */

public class CookieTokenTableConnect {
    protected static String url;
    protected static String user;
    protected static String password;
    protected static String tableWithUserCookieID;

    public CookieTokenTableConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        password = DBproperties.passwordDB;
        tableWithUserCookieID = DBproperties.tableCooke;
    }
}
