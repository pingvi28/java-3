package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangeEmailConfirmed;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangerUserDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private boolean remember = false;
    ChangerUserDB connection = new ChangerUserDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String token = req.getParameter("token");
        // есть ли токен == перешел по почте
        if(token != null ) {
            if (!token.equals("")){
                System.out.print("user " + session.getAttribute("id_user"));
                if(session.getAttribute("id_user") != null){
                    ChangeEmailConfirmed.changeEmailConfirmed((Integer) session.getAttribute("id_user"));
                }
            }
        }
        req.getRequestDispatcher("/WEB-INF/view/indexLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = connection.validate(email, password);

        if(req.getParameter("remember") != null){
            remember = true;
        }

        if (id > 0) {
            Cookie userCookie = new Cookie("user_id_cookie",  Integer.toString(id));
            resp.addCookie(userCookie);
            if (remember) {

                Cookie rememberCookie = new Cookie("remember_cookie", String.valueOf(true));
                rememberCookie.setMaxAge(60*60*24*5);
                resp.addCookie(rememberCookie);
            }
            req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
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