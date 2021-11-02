package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;
import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.EmailSender;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/send")
public class SendEmailAgainServlet extends HttpServlet {
    private final String themeEmail = "Подтвердите свою почту (повторное письмо)";
    private String link = "";
    private int user_idCookie = -1;

    public void init(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                switch (c.getName()) {
                    case ("user_id_cookie"):
                        user_idCookie = Integer.parseInt(c.getValue());
                        break;
                }
            }
        }else{
            System.out.println ("Данные cookie не получены");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("FirstTitle", "Все, я отправил тебе письмо-подтверждение на почту<br/><br/>");
        req.setAttribute("SecondTitle", "если оно не пришло, нажми на кнопку ниже / глянь спам<br/>перейди по ссылке, указаной в письме :з <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexAfterSU.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        link = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        System.out.println("cooc" + user_idCookie);
        if(user_idCookie != -1){
            link = link + getServletContext().getContextPath() + "/login?token=" + UserTokenEmail.returnToken(user_idCookie);
            String sendTextEmail = "Hello!<br/> <br/> " +
                    "Today is date |[" + UserTokenEmail.returnDataRegistration(user_idCookie) + " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>" + link + "&confirm=true .\n ";

            EmailSender.here.sendEmail(themeEmail, sendTextEmail, UserDB.returnEmail(user_idCookie));
            resp.sendRedirect(getServletContext().getContextPath() + "/send?sendEmail=true");
        }
        else {
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-20");
        }
    }
}