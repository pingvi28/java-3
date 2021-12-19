package ru.kpfu.itis;

import javax.net.ssl.HttpsURLConnection;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private static         int port = 8081;
    protected static String param1 = "";
    protected static String param2 = "";
    protected static boolean URLflag = false;

    public static void main(String[] ar)    {

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept();
            System.out.println("Got a client\n");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String urlLine = null;
            while(true) {
                urlLine = in.readUTF();
                System.out.println("The client just sent me this url : " + urlLine);
                if(findParam(urlLine)){
                    responseURL(urlLine, out);
                    out.writeUTF("stop");
                    out.writeUTF(returnSum());
                }
                else{
                    out.writeUTF("Your url uncorrected!\n");
                    out.writeUTF("stop");
                    out.writeUTF("");
                }

                out.flush(); // заставляем поток закончить передачу данных.
                param2 = "";
                param1 = "";
                System.out.println("Waiting for the next line...\n");
                System.out.println();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }

    protected static boolean findParam(String url) {
        Pattern pattern = Pattern.compile("^((https?|ftp|file):\\/\\/[-a-zA-Z0-9+@#\\/%?~_|!:,.;]*[-a-zA-Z0-9+@#%~_|])\\/[-a-zA-Z0-9+&@#\\/%?~_|!:,.;]*=?([0-9]*)?&?[-a-zA-Z0-9+@#%?~_|!:,.;]*=?([0-9]*)?");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()){
            param1 = matcher.group(3);
            param2 = matcher.group(4);
            if (matcher.group(1) != null) URLflag = true;
        }
        return URLflag;
    }

    protected static String returnSum(){
        if(param1.equals("") || param2.equals("")){
            return "your didn't write param";
        }
        return "your sum:" + (Integer.parseInt(param1) + Integer.parseInt(param2));

    }
    protected static void responseURL(String url, DataOutputStream out) throws IOException {
        URL myUrl;
        HttpsURLConnection myUrlCon = null;

        try {
            myUrl = new URL(url );
            myUrlCon =
                    (HttpsURLConnection) myUrl.openConnection();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        out.writeUTF("Метод запроса: " + myUrlCon.getRequestMethod());

        out.writeUTF("Ответное сообщение: " + myUrlCon.getResponseMessage());

        out.writeUTF("Content-Type: text/plain");
        out.writeUTF("charset: utf-8");

        // Получить список полей и множество ключей из заголовка

//        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
//        Set<String> myField = myMap.keySet();
//
//        for(String k : myField) {
//            if(k == null) {k = "";}
//            else k += ": ";
//            out.writeUTF(k + myMap.get(k));
//        }
    }
}