package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.MyHash;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.ChangerUserDBService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateNS")
public class UpdateNSServlet extends HttpServlet{
    private String user_idCookie = "";

    public void init(HttpServletRequest req) {
        UserDBParam userDBParam = new UserDBParam();
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = c.getValue();
                }
            }
        }else{
            System.out.println ("Данные cookie не получены");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        String name = req.getParameter("changedName");
        String surname = req.getParameter("changedSurname");
        String password = req.getParameter("passwordCur");

        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        if(MyHash.createHashPassword(password).equals(UserDBParam.returnStringParam(userID,"hash"))){
            if(name.equals("null")){
                name = UserDBParam.returnStringParam(userID,"name");
            }
            if(surname.equals("null")){
                name = UserDBParam.returnStringParam(userID,"surname");
            }
            boolean success = ChangerUserDBService.updateProfileNS(userID,name,surname);
            if(success){
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=success");
            }
            else {
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-11");
            }
        }
        else{
            resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-10");
        }
    }
}
