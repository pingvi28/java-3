package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.EmailSender;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDB;
import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private final String themeEmail = "Подтвердите свою почту";
    private String link = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexSignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        link = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        HttpSession session = req.getSession(true);
        UserDB dbconnection = new UserDB();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean remember = Boolean.parseBoolean(req.getParameter("remember"));

        if (!dbconnection.validate(email)) {
            int userId = dbconnection.add(name, surname, email, password);
            if(session.getAttribute("id_user") == null) {
                session.setAttribute("id_user", userId);
                System.out.println("Session data are set");
            }
            else {
                System.out.println("User id: " + userId);
                // удаляем объект с ключом name
                session.removeAttribute("id_user");
                session.setAttribute("id_user", userId);
                System.out.println("New session data are set");
            }

            Cookie userIDCookie = new Cookie("user_id_cookie",  Integer.toString(userId));
            userIDCookie.setMaxAge(60*60*2);
            resp.addCookie(userIDCookie);

            link = link + getServletContext().getContextPath() + "/login?token=" +  UserTokenEmail.returnToken(userId);
            String sendTextEmail = "Hello!<br/> <br/> " +
                    "Today is date |[" + UserTokenEmail.returnDataRegistration(userId) + " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>" + link + "&confirm=true .\n ";

            EmailSender.here.sendEmail(themeEmail, sendTextEmail,email);

            resp.sendRedirect(getServletContext().getContextPath() + "/send");
        } else {
            System.out.println("Entered email contains in DB: " + email);
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-10");
        }
    }
}