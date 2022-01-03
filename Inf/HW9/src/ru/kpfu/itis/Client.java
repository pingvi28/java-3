package ru.kpfu.itis;
import java.net.*;
import java.util.regex.Pattern;

public class Client {
    protected HttpServer http;
    protected static String address = "localhost";
    protected static int serverPort = 8080;
    protected static String defaultURL = "http://www.google.com";
    protected String urlPath = "";
    protected String urlParameters = "";
    protected String clientName = "";

    public Client(String name, String address){
        clientName = name;
        this.address = address;
        http = new HttpServer(serverPort);
        clearURLPart();
        connectWithSocket();
    }

    public Client(String name, String address, int serverPort){
        clientName = name;
        this.address = address;
        setServerPort(serverPort);
        http = new HttpServer(serverPort);
        clearURLPart();
        connectWithSocket();
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Client.address = address;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static void setServerPort(int serverPort) {
        if( serverPort >= 1025 && serverPort <= 65535){
            Client.serverPort = serverPort;
        }
    }

    public static String getDefaultURL() {
        return defaultURL;
    }

    public static void setDefaultURL(String defaultURL) {
        Client.defaultURL = defaultURL;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        Pattern pattern = Pattern.compile("\\/.++");
        if(pattern.matcher(urlPath).matches()){
            this.urlPath = urlPath;
        }
        else{
            this.urlPath = "/" + urlPath;
        }
    }

    public String getUrlParameters() {
        return urlParameters;
    }

    public void setUrlParameters(String urlParameters) {
        Pattern pattern = Pattern.compile("\\?.++");
        if(pattern.matcher(urlParameters).matches()){
            this.urlParameters = urlParameters;
        }
        else{
            this.urlParameters = "/" + urlParameters;
        }
    }

    public void connectWithSocket(){
        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает хост или IP-адрес.
            System.out.println("\nHi, " + clientName + ". You heard of a socket with host: " + address + " and port: " + serverPort );

            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Connected with socket\n\n");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void setMethod(String method){
        if(method.toUpperCase().equals("GET")){
            try {
                http.sendGet(defaultURL + urlPath + urlParameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            if(method.toUpperCase().equals("POST")){
                try {
                    http.sendPost(defaultURL + urlPath,  urlParameters);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Unknown method :(");
            }
        }
    }

    public void clearURLPart(){
        this.urlPath = "";
        this.urlParameters = "";
    }
}
