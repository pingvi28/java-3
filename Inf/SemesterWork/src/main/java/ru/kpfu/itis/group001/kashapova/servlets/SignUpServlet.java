package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.confirmDB.ConfirmUserTableParam;
import ru.kpfu.itis.group001.kashapova.services.EmailSenderService;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.ChangerUserTableService;
import ru.kpfu.itis.group001.kashapova.services.confirmDB.UserTokenEmailServices;

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
        ChangerUserTableService dbconnection = new ChangerUserTableService();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!dbconnection.validate(email)) {
            String userIdCookie = dbconnection.add(name, surname, email, password);

            Cookie userIDCookie = new Cookie("user_id_cookie",  userIdCookie);
            userIDCookie.setMaxAge(60*60*2);
            resp.addCookie(userIDCookie);

            link = link + getServletContext().getContextPath() + "/login?token=" +  UserTokenEmailServices.returnToken(ChangerCookieTokenService.returnUserID(userIdCookie));

            String sendTextEmail = "Hello!<br/> <br/> " +
                    "Today is date |[" + ConfirmUserTableParam.returnDataRegistration(ChangerCookieTokenService.returnUserID(userIdCookie)) +
                    " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>"
                    + link + "&confirm=true .\n ";

            EmailSenderService.here.sendEmail(themeEmail, sendTextEmail,email);

            resp.sendRedirect(getServletContext().getContextPath() + "/send");
        } else {
            System.out.println("Entered email contains in DB: " + email);
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-10");
        }
    }
}
