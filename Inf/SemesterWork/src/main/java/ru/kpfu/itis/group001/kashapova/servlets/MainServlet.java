package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.confirmDB.ConfirmUsersConnect;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserConnnect;
import ru.kpfu.itis.group001.kashapova.java_class.userDB.UserDBParam;

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
        ConfirmUsersConnect confirmUsersConnect= new ConfirmUsersConnect();

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies) {
                if ("user_id_cookie".equals(c.getName())) {
                    user_idCookie = Integer.parseInt(c.getValue());
                }
            }
        }else{
            System.out.println ("Данные cookie не получены");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        UserDBParam userDBParam = new UserDBParam();
        req.setAttribute("FirstName", userDBParam.returnStringParam(user_idCookie,"name"));
        req.getRequestDispatcher("/WEB-INF/view/indexMain.jsp").forward(req, resp);
    }
}
