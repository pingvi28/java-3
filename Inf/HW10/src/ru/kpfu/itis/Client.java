package ru.kpfu.itis;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] ar) {
        int serverPort = 8081;

        try {
            Socket socket = new Socket("localhost", serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String lineURL = null;
            System.out.println("Type in something and press enter");

            while (true) {
                lineURL = bufferedReader.readLine();
                System.out.println("Sending this url to the server...");
                out.writeUTF(lineURL);
                out.flush();

                while (true){
                    lineURL = in.readUTF();
                    if(lineURL.equals("stop")){break;}
                    System.out.println(lineURL);
                }
                lineURL = in.readUTF();
                if(!lineURL.equals("")) System.out.println("\n   response : " + lineURL + "\n");
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}