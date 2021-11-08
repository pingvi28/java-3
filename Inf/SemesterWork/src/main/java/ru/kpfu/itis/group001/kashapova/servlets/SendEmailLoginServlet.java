package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.confirmDB.ConfirmUserDBParam;
import ru.kpfu.itis.group001.kashapova.services.confirmDB.UserTokenEmailServices;
import ru.kpfu.itis.group001.kashapova.java_class.EmailSender;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sendAgain")
public class SendEmailLoginServlet extends HttpServlet {
    private final String themeEmail = "Подтвердите свою почту (повторное письмо)";
    private String user_idCookie = "";

    public void init(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = c.getValue();
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
        UserTokenEmailServices userTokenEmailServices = new UserTokenEmailServices();
        init(req);
        String link = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        if(userID != -1){
            System.out.println();
            link = link + getServletContext().getContextPath() + "/login?token=" + userTokenEmailServices.returnToken(userID);
            String sendTextEmail = "Hello!<br/> <br/> " +
                    "|[" + ConfirmUserDBParam.returnDataRegistration(userID) + " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>" + link + "&confirm=true .\n ";

            EmailSender.here.sendEmail(themeEmail, sendTextEmail, UserDBParam.returnStringParam(userID,"email"));
            resp.sendRedirect(getServletContext().getContextPath() + "/sendAgain?sendEmail=true");
        }
        else {
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-20");
        }
    }
}