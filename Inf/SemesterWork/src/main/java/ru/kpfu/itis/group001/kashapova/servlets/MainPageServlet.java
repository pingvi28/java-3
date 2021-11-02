package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.userDB.ChangeEmailConfirmed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
    private String token;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        token = req.getParameter("token");
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);

        // есть ли токен == перешел по почте
        if(token != null) {
            System.out.print("user " + session.getAttribute("id_user"));
            ChangeEmailConfirmed.changeEmailConfirmed((Integer) session.getAttribute("id_user"));
        }
    }
}
