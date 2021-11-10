package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.confirmDB.ConfirmUserTableParam;
import ru.kpfu.itis.group001.kashapova.services.confirmDB.UserTokenEmailServices;
import ru.kpfu.itis.group001.kashapova.services.EmailSenderService;
import ru.kpfu.itis.group001.kashapova.services.cookieTokenDB.ChangerCookieTokenService;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserTableParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/send")
public class SendEmailAgainServlet extends HttpServlet {
    private final String themeEmail = "Подтвердите свою почту (повторное письмо)";
    private String link = "";
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
        req.setAttribute("FirstTitle", "Все, я отправил тебе письмо-подтверждение на почту<br/><br/>");
        req.setAttribute("SecondTitle", "если оно не пришло, нажми на кнопку ниже / глянь спам<br/>перейди по ссылке, указаной в письме :з <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
        req.setAttribute("sendAgain", "yes");
        req.removeAttribute("sendLogin");
        getServletContext().getRequestDispatcher("/WEB-INF/view/indexSendEmailConfirm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        link = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
        int userID = ChangerCookieTokenService.returnUserID(user_idCookie);
        if(userID != -1){
            link = link + getServletContext().getContextPath() + "/login?token=" + UserTokenEmailServices.returnToken(userID);
            String sendTextEmail = "Hello!<br/> <br/> " +
                    "Today is date |[" + ConfirmUserTableParam.returnDataRegistration(userID) + " ]|, a certain user registered on the site 'Lamp corner' using your email. " +
                    "<br/>If it was you, then please confirm your email address by following this link: <br/>" + link + "&confirm=true .\n ";

            EmailSenderService.here.sendEmail(themeEmail, sendTextEmail, UserTableParam.returnStringParam(userID,"email"));
            resp.sendRedirect(getServletContext().getContextPath() + "/send?sendEmail=true");
        }
        else {
            resp.sendRedirect(getServletContext().getContextPath() + "/signUp?return=-20");
        }
    }
}
