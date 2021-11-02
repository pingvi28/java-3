package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/corner")
public class MainServlet extends HttpServlet {
    private int user_idCookie;
    private String tokenCookie;
    private boolean rememberCookie = false;
    private boolean remember = false;

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
        }else{
            System.out.println ("Данные cookie не получены");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);

        if ( (user_idCookie > 0) && (tokenCookie != null)) {

            System.out.println("ere " + tokenCookie);

            req.setAttribute("email", UserDB.returnEmail(user_idCookie));
            System.out.println("123");
            req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect(getServletContext().getContextPath() + "/login");
        }
    }
}
