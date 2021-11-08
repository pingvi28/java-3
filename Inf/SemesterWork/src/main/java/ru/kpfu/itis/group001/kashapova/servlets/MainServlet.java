package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.services.confirmDB.ConfirmUsersConnect;
import ru.kpfu.itis.group001.kashapova.services.userDB.UserDBParam;

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
        init(req);
        UserDBParam userDBParam = new UserDBParam();
        ConfirmUsersConnect confirmUsersConnect = new ConfirmUsersConnect();
        req.setAttribute("FirstName", UserDBParam.returnStringParam(user_idCookie,"name"));
        req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
    }
}
