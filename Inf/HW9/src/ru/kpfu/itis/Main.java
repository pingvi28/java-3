package ru.kpfu.itis;

public class Main {
    public static void  main(String[] ar) {
        Client client1 = new Client("client 1", "localhost");
        client1.setUrlPath("/search");
        client1.setUrlParameters("?java");
        client1.setMethod("get");

        Client client2 = new Client("client 2","localhost", 8081);
        client2.setDefaultURL("https://javarush.ru");
        client2.setUrlPath("/groups");
        client2.setMethod("post");
    }
}
