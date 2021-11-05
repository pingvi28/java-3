package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.MyHash;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangerUserDB;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePas")
public class UpdatePasServlet extends HttpServlet {
    private int user_idCookie;

    public void init(HttpServletRequest req) {
        UserDBParam userDBParam = new UserDBParam();
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = Integer.parseInt(c.getValue());
                }
            }
        }else{
            System.out.println ("Данные cookie не получены");
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
        String passwordRep = req.getParameter("passwordRep");

        if(MyHash.createHashPassword(password).equals(UserDBParam.returnStringParam(user_idCookie,"hash"))){
            boolean success = ChangerUserDB.updateProfilePass(user_idCookie,passwordRep);
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
