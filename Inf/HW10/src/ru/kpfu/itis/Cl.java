package ru.kpfu.itis;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This program demonstrates a client socket application that connects to
 * a web server and send a HTTP HEAD request.
 *
 * @author www.codejava.net
 */
public class Cl {
    private static String url = "http://pro-java.ru";
    protected static int param1;
    protected static int param2;
    protected static String query;

    public static void main(String[] args) {
        URL myUrl = null;
        HttpURLConnection myUrlCon = null;
        param1 = 1;
        param1 = 2;

        query = "param1=" + param1 + "&param2=" + param1;
        try {
            myUrl = new URL(url + "?" + query);
            myUrlCon =
                    (HttpURLConnection) myUrl.openConnection();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        String hostname = myUrl.getHost();
        int port = 80;

        try (Socket socket = new Socket(hostname, port)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            System.out.println("Метод запроса: " +
                    myUrlCon.getRequestMethod());

            System.out.println("Ответное сообщение: " +
                    myUrlCon.getResponseMessage());

            // Получить список полей и множество ключей из заголовка

            Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
            Set<String> myField = myMap.keySet();
            System.out.println("\nДалее следует заголовок:");

            for(String k : myField) {
                System.out.println(k + myMap.get(k));
            }

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}