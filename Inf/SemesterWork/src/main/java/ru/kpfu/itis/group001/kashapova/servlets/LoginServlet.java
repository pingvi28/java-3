package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.userDB.ChangeEmailConfirmedServices;
import ru.kpfu.itis.group001.kashapova.services.userDB.ChangerUserDBServices;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private boolean remember = false;
    ChangerUserDBServices connection = new ChangerUserDBServices();
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
        String vkLink = "https://oauth.vk.com/authorize?client_id=7984087&display=page&redirect_uri=" +
                req.getScheme() + "://" + req.getServerName() +
                ":" + req.getServerPort() + getServletContext().getContextPath() +
                "/vk_auth&scope=email&response_type=code&v=5.131";

        req.setAttribute("VKlink", vkLink);
        String token = req.getParameter("token");
        // есть ли токен == перешел по почте -> меняю параметр
        if(token != null && !token.equals("")) {
            if(user_idCookie > 0){
                System.out.println("do" + user_idCookie);
                ChangeEmailConfirmedServices.changeEmailConfirmed(user_idCookie);
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
            userCookie.setMaxAge(60*60*24*5);
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
