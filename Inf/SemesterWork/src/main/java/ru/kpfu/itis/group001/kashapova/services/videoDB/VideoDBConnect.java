package ru.kpfu.itis.group001.kashapova.services.videoDB;

import properties.DBproperties;

import java.sql.Connection;
import java.sql.Statement;

public class VideoDBConnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String passwordDB;
    protected static String tableWithVideo;

    /**
     * конструктор для присваивания параметров бд и установления связи
     */
    public VideoDBConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        passwordDB = DBproperties.passwordDB;
        tableWithVideo = DBproperties.tableVideo;
    }
}
