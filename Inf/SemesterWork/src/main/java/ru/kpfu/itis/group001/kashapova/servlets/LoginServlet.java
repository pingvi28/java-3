package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.ConfirmUsersConnect;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangeEmailConfirmed;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangerUserDB;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private boolean remember = false;
    ChangerUserDB connection = new ChangerUserDB();
    private int user_idCookie = -1;

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
        String token = req.getParameter("token");
        // есть ли токен == перешел по почте -> меняю параметр
        System.out.println("do" + user_idCookie);
        if(token != null && !token.equals("")) {
            if(user_idCookie > 0){
                System.out.println("do" + user_idCookie);
                ChangeEmailConfirmed.changeEmailConfirmed(user_idCookie);
            }
        }
        req.getRequestDispatcher("/WEB-INF/view/indexLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = connection.validate(email, password);
        //поставил ли галку запомнить меня
        if(req.getParameter("remember") != null){
            remember = true;
        }

        boolean flag = UserDBParam.returnConfirmFlag(user_idCookie);

        if (id > 0) {
            Cookie userCookie = new Cookie("user_id_cookie",  Integer.toString(id));
            resp.addCookie(userCookie);
            if(flag){
                if (remember) {
                    Cookie rememberCookie = new Cookie("remember_cookie", String.valueOf(true));
                    rememberCookie.setMaxAge(60*60*24*5);
                    resp.addCookie(rememberCookie);
                }
                resp.sendRedirect(getServletContext().getContextPath() + "/corner");
            }else{
                resp.sendRedirect(getServletContext().getContextPath() + "/sendAgain");
            }
        } else {
            if(id == -1) {
                resp.sendRedirect(getServletContext().getContextPath() + "/login?return=-11");
            }
            if(id == -2) {
                resp.sendRedirect(getServletContext().getContextPath() + "/login?return=-12");
            }
        }
    }
}
