package ru.kpfu.itis.group001.kashapova.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fullName","Z wewr");
        req.setAttribute("email","adas@sds");
        req.getRequestDispatcher("/WEB-INF/view/indexUserProfile.jsp").forward(req, resp);
    }
}
