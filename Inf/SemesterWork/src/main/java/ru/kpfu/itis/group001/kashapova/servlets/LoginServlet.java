package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangeEmailConfirmed;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String token;
    private boolean remember = false;
    UserDB connection = new UserDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        token = req.getParameter("token");
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
            if (remember) {
                Cookie userCookie = new Cookie("user_id_cookie",  Integer.toString(id));
                Cookie rememberCookie = new Cookie("remember_cookie", String.valueOf(remember));
                userCookie.setMaxAge(60*60*24*5);
                resp.addCookie(userCookie);
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