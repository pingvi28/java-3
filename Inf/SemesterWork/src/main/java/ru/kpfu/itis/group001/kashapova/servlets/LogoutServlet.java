package ru.kpfu.itis.group001.kashapova.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = null;
        cookies = req.getCookies();

        if(cookies!=null){
            for(Cookie c:cookies) {
                switch (c.getName()) {
                    case ("user_id_cookie"):
                    case ("remember_cookie"):
                        c.setValue("");
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        break;
                }
            }
        }
        HttpSession session = req.getSession(true);
        System.gc();
        resp.sendRedirect(getServletContext().getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Here");
    }
}