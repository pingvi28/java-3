package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/openCorner")
public class OpenServlet extends HttpServlet {
    private int user_idCookie;
    private boolean rememberCookie = false;

    public void init(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                switch (c.getName()) {
                    case ("user_id_cookie"):
                        user_idCookie = Integer.parseInt(c.getValue());
                        break;
                    case ("remember_cookie"):
                        rememberCookie = Boolean.parseBoolean(c.getValue());
                        break;
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);

        if ( (user_idCookie > 0) & rememberCookie) {

            req.setAttribute("email", UserDBParam.returnStringParam(user_idCookie,"email"));
            resp.sendRedirect(getServletContext().getContextPath() + "/corner");
        }
        else{
            resp.sendRedirect(getServletContext().getContextPath() + "/login");
        }
    }
}
