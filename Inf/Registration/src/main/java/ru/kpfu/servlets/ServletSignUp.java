package ru.kpfu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/up")
public class ServletSignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexSignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBcon dbconnection = new DBcon();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password-repeat");
        System.out.println(name + " " + surname + " " + email + " " + password + " " + password2);

        if (password.equals(password2)) {
            if (!dbconnection.validate(email)) {
                dbconnection.add(name, surname, email, password);
                System.out.println("Registered user: " + name + " " + surname + " " + email);
                req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
            } else {
                System.out.println("Entered email contains in DB: " + email);
                req.getRequestDispatcher("/WEB-INF/view/indexError.jsp").forward(req, resp);
            }
        } else {
            System.out.println("Entered password don't equal " + password + " " + password2);
            req.getRequestDispatcher("/WEB-INF/view/indexError.jsp").forward(req, resp);
        }
    }
}