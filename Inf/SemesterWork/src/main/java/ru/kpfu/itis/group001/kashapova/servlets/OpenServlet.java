package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.VideoLink;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.videoDB.VideoDBConnect;
import ru.kpfu.itis.group001.kashapova.services.videoDB.VideoDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/openCorner")
public class OpenServlet extends HttpServlet {
    private String user_idCookie = "";
    private boolean rememberCookie = false;

    public void init(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                switch (c.getName()) {
                    case ("user_id_cookie"):
                        user_idCookie = c.getValue();
                        break;
                    case ("remember_cookie"):
                        rememberCookie = Boolean.parseBoolean(c.getValue());
                        break;
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VideoDBConnect videoDBConnect = new VideoDBConnect();
        VideoLink.setVideoLink(VideoDBParam.returnVideoArray());
        init(req);
        ChangerCookieTokenService cookieTokenDB = new ChangerCookieTokenService();
        if ( (user_idCookie != null) & rememberCookie) {
            if(cookieTokenDB.returnUserID(user_idCookie) > 0){
                System.gc();
                resp.sendRedirect(getServletContext().getContextPath() + "/corner");
            }
        }
        else{
            System.gc();
            resp.sendRedirect(getServletContext().getContextPath() + "/login");
        }
    }
}
