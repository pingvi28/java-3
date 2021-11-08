//https://vk.com/dev.php?method=authcode_flow_user
package ru.kpfu.itis.group001.kashapova.servlets;

import ru.kpfu.itis.group001.kashapova.java_class.VK.VKAccessToken;
import ru.kpfu.itis.group001.kashapova.java_class.VK.VKOauthUser;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import java.net.URL;
import java.net.URLConnection;


@WebServlet("/vk_auth")
public class VKAuthServlet extends HttpServlet {
    final String clientId = "7984087";
    final String clientSecret = "VKa2DApqDI4iQgH30KcW";
    private final Gson gson = new Gson();
    private VKAccessToken accessToken;
    private VKOauthUser vkOauthUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //REDIRECT_URI? - проверять в вк приложении при ошибке
        String code = req.getParameter("code");

        if (code != null) {
            getAccessToken(req,code);
        }else {
            resp.sendRedirect(getServletContext().getContextPath() + "/login?vkAuth=0");
        }

        if(accessToken.access_token != null){
            getInfo();
            vkOauthUser.email = accessToken.email;
        }else {
            resp.sendRedirect(getServletContext().getContextPath() + "/login?vkAuth=1");
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/corner");
    }

    /**
     * https://vk.com/dev/access_token
     * @param req
     * @param code
     * @throws IOException
     */
    private void getAccessToken(HttpServletRequest req, String code) throws IOException {
        URL url = new URL("https://oauth.vk.com/access_token?client_id="
                + clientId + "&client_secret=" + clientSecret +
                "&redirect_uri=" + req.getScheme() + "://" + req.getServerName() +
                ":" + req.getServerPort() + getServletContext().getContextPath() + "/vk_auth&" +
                "code=" + code);

        //получаем данные из запроса
        accessToken = gson.fromJson(returnBody(url), VKAccessToken.class);
    }

    /**
     * https://vk.com/dev/api_requests
     * @throws IOException
     */
    private void getInfo() throws IOException {
        URL url = new URL("https://api.vk.com/method/users.get?" +
                "user_ids=" + accessToken.user_id+
                "&access_token=" + accessToken.access_token+
                "&v=5.131");

        String body = returnBody(url);
        body = body.replace ("{\"response\":[", "");
        body = body.replace ("]}", "");

        //получаем данные из запроса
        vkOauthUser = gson.fromJson(body, VKOauthUser.class);
    }

    private String returnBody(URL url) throws IOException {
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        return new BufferedReader(new InputStreamReader(in, encoding)).readLine();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Here");
    }
}
