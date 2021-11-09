package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.MyHash;
import ru.kpfu.itis.group001.kashapova.services.confirmDB.UserTokenEmailServices;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.ChangerUserDBService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserConnnect;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAccount")
public class DeleteUserServlet extends HttpServlet {
    private String user_idCookie = "";
    private UserConnnect connnect = new UserConnnect();

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
        req.getRequestDispatcher("/WEB-INF/view/indexLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        String password = req.getParameter("passwordCur3");

        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        if(MyHash.createHashPassword(password).equals(UserDBParam.returnStringParam(userID,"hash"))){
            boolean success = ChangerUserDBService.deleteProfile(userID);
            if(success){
                resp.sendRedirect(getServletContext().getContextPath() + "/logout?delete=success");
            }
            else {
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?delete=-11");
            }
        }
        else{
            resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-10");
        }
    }
}