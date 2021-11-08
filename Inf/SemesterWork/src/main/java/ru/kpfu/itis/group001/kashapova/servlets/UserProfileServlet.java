package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
    private String user_idCookie = "";
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
        UserDBParam userDBParam = new UserDBParam();
        int userID = changerCookieTokenService.returnUserID(user_idCookie);

        req.setAttribute("FirstName", UserDBParam.returnStringParam(userID,"name"));
        req.setAttribute("fullName",UserDBParam.returnStringParam(userID,"surname") + " " + UserDBParam.returnStringParam(userID,"name"));
        req.setAttribute("email",UserDBParam.returnStringParam(userID,"email"));

        req.getRequestDispatcher("/WEB-INF/view/indexUserProfile.jsp").forward(req, resp);
    }
}
