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

@WebServlet("/updateNS")
public class UpdateNSServlet extends HttpServlet{
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        String name = req.getParameter("changedName");
        String surname = req.getParameter("changedSurname");
        String password = req.getParameter("passwordCur");
        System.out.println(name+ " " + surname + " " +password);
        if(MyHash.createHashPassword(password).equals(UserDBParam.returnStringParam(user_idCookie,"hash"))){
            if(name.equals("null")){
                name = UserDBParam.returnStringParam(user_idCookie,"name");
            }
            if(surname.equals("null")){
                name = UserDBParam.returnStringParam(user_idCookie,"surname");
            }
            boolean success = ChangerUserDB.updateProfileNS(user_idCookie,name,surname);
            if(success){
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile");
            }
            else {
                resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-11");
            }
        }
        else{
            System.out.println("3");
            resp.sendRedirect(getServletContext().getContextPath() + "/userProfile?update=-10");
        }
    }
}
