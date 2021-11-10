package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.MyHash;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.ChangerUserTableService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserTableParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePas")
public class UpdatePasServlet extends HttpServlet {
    private String user_idCookie = "";

    public void init(HttpServletRequest req) {
        UserTableParam userTableParam = new UserTableParam();
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
        req.getRequestDispatcher("/WEB-INF/view/indexUserProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        String password = req.getParameter("passwordCur2");
        String passwordNew = req.getParameter("passwordRep");

        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        if(MyHash.createHashPassword(password).equals(UserTableParam.returnStringParam(userID,"hash"))){
            boolean success = ChangerUserTableService.updateProfilePass(userID,passwordNew);
            if(success){
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=success");
            }
            else {
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-12");
            }
        }
        else{
            resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-10");
        }
    }
}
