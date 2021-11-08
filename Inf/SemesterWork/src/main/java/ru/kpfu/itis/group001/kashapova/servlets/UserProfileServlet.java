package ru.kpfu.itis.group001.kashapova.servlets;

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
    private int user_idCookie;
    private boolean rememberCookie = false;

    public void init(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = Integer.parseInt(c.getValue());
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        UserDBParam userDBParam = new UserDBParam();
        req.setAttribute("FirstName", UserDBParam.returnStringParam(user_idCookie,"name"));

        req.setAttribute("fullName",UserDBParam.returnStringParam(user_idCookie,"surname") + " " + UserDBParam.returnStringParam(user_idCookie,"name"));
        req.setAttribute("email",UserDBParam.returnStringParam(user_idCookie,"email"));

        req.getRequestDispatcher("/WEB-INF/view/indexUserProfile.jsp").forward(req, resp);
    }
}
