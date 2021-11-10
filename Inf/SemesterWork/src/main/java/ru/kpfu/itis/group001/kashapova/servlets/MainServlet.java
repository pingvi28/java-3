package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.VideoLinkArray;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserTableParam;
import ru.kpfu.itis.group001.kashapova.services.videoDB.VideoDBConnect;
import ru.kpfu.itis.group001.kashapova.services.videoDB.VideoDBParam;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/corner")
public class MainServlet extends HttpServlet {
    private String user_idCookie ="";
    private ChangerCookieTokenService changerCookieTokenService = new ChangerCookieTokenService();

    public void init(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = c.getValue();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        Gson g = new Gson();
        UserTableParam userTableParam = new UserTableParam();
        VideoDBConnect videoDBConnect = new VideoDBConnect();
        if(VideoLinkArray.getVideoLink().length == 0){
            VideoLinkArray.setVideoLink(VideoDBParam.returnVideoArray());
        }
        String[] video = VideoLinkArray.getVideoLink();

        String jsonVideoArray = g.toJson(video);
        req.setAttribute("jsonVideoArray",jsonVideoArray);

        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        req.setAttribute("FirstName", userTableParam.returnStringParam(userID,"name"));
        req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = req.getParameter("link");
        System.out.println("l  " + link);
    }
}
