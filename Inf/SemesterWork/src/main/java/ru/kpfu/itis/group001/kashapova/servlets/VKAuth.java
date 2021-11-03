package ru.kpfu.itis.group001.kashapova.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/vk_auth")
public class VKAuth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Here");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        System.out.println("code: " + code);

        URL url = new URL("https://oauth.vk.com/access_token?" +
                "client_id=7984087&" +
                "client_secret=VKa2DApqDI4iQgH30KcW&" +
                "redirect_uri=http://localhost:8084/lamp/vk_auth&" +
                "code=" + code);

        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String body = new BufferedReader(new InputStreamReader(in, encoding)).readLine();
        System.out.println("body: " + body);

        resp.sendRedirect("http://localhost:8084/lamp/corner");
    }
}
