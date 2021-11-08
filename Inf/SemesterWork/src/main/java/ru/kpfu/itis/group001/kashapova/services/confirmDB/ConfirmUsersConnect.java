package ru.kpfu.itis.group001.kashapova.services.confirmDB;

import properties.DBproperties;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class ConfirmUsersConnect {
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableConfirmUsers;

    public ConfirmUsersConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableConfirmUsers = DBproperties.tableConfirmUsers;
    }
}
