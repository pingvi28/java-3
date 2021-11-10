package ru.kpfu.itis.group001.kashapova.services.confirmDB;

import properties.DBproperties;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * конструктор для присваивания параметров бд и установления связи с confirm_users
 */

public class ConfirmUsersTableConnect {
    protected static String url;
    protected static String user;
    protected static String password;
    protected static String tableConfirmUsers;

    public ConfirmUsersTableConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        password = DBproperties.passwordDB;
        tableConfirmUsers = DBproperties.tableConfirmUsers;
    }
}
