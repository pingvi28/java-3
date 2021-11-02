package ru.kpfu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexLogIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBcon dbconnection = new DBcon();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (dbconnection.validate(email, password) > 0) {
            req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
        } else {
            System.out.println("Entered email contains in DB: " + email);
            req.getRequestDispatcher("/WEB-INF/view/indexError.jsp").forward(req, resp);
        }
    }
}