package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangeEmailConfirmed;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangerUserDB;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                switch (c.getName()) {
                    case ("user_id_cookie"):
                    case ("remember_cookie"):
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        break;
                }
            }
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/login");
    }
}