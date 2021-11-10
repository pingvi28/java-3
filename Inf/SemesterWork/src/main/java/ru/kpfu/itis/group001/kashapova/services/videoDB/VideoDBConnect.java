package ru.kpfu.itis.group001.kashapova.services.videoDB;

import properties.DBproperties;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 *  конструктор для присваивания параметров бд и установления связи с video_main
 */

public class VideoDBConnect {
    protected static Connection connection;
    protected static Statement statement;
    protected static String url;
    protected static String user;
    protected static String password;
    protected static String tableWithVideo;

    public VideoDBConnect() {
        url = DBproperties.url;
        user = DBproperties.user;
        password = DBproperties.passwordDB;
        tableWithVideo = DBproperties.tableVideo;
    }
}
