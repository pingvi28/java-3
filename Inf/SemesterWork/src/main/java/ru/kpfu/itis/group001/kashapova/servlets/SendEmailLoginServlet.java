package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.ConfirmUserDBParam;
import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.ConfirmUsersConnect;
import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.UserTokenEmail;
import ru.kpfu.itis.group001.kashapova.java_class.subsidiary.EmailSender;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sendAgain")
public class SendEmailLoginServlet extends HttpServlet {
    private final String themeEmail = "Подтвердите свою почту (повторное письмо)";
    private int user_idCookie = -1;

    public void init(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = Integer.parseInt(c.getValue());
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("FirstTitle", "Извини, я не могу тебя пустить...<br/><br/>");
        req.setAttribute("SecondTitle", "Подтверди свою почту. Нажми на кнопку ниже / глянь спам<br/>перейди по ссылке, указаной в письме :з <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
        req.setAttribute("sendLogin", "yes");
        req.removeAttribute("sendAgain");
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexSendEmailConfirm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserTokenEmail userTokenEmail = new UserTokenEmail();
        init(req);
        String link = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        if(user_idCookie != -1){
            System.out.println();
            link = link + getServletContext().getContextPath() + "/login?token=" + userTokenEmail.returnToken(user_idCookie);
            String sendTextEmail = "Hello!<br/> <br/> " +
                    "|[" + ConfirmUserDBParam.returnDataRegistration(user_idCookie) + " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>" + link + "&confirm=true .\n ";

            EmailSender.here.sendEmail(themeEmail, sendTextEmail, UserDBParam.returnStringParam(user_idCookie,"email"));
            resp.sendRedirect(getServletContext().getContextPath() + "/sendAgain?sendEmail=true");
        }
        else {
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-20");
        }
    }
}