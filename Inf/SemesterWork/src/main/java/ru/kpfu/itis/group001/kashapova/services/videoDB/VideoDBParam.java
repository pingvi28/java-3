package ru.kpfu.itis.group001.kashapova.services.videoDB;

import java.sql.*;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 *
 * возращение небходимых полей из video_main
 */

public class  VideoDBParam extends VideoDBConnect{
    public static String[] videoLink;

    public static String[] returnVideoArray(){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            Class.forName("org.postgresql.Driver");
            int count = getNumberRows();
            videoLink = new String[count];

            ResultSet rs = statement.executeQuery("select * from " + tableWithVideo + ";");
            int index = 0;
            while (rs.next()) {
                videoLink[index] = rs.getString("video_link");
                index++;
            }
            if (!rs.next()) return videoLink; //нет пользователя
            return videoLink;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("(VDBP#returnVideoArray :" + e.getMessage() + " : " + e.getCause());
            return videoLink;
        }
    }

    private static int getNumberRows(){
        try(Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("select * from " + tableWithVideo + ";");
            rs = statement.executeQuery("select count (*) from " + tableWithVideo + ";");
            rs.next();
            return rs.getInt(1);
        } catch (Exception e){
            System.out.println("VDBP#Error getting row count");
            e.printStackTrace();
        }
        return 0;
    }
}
