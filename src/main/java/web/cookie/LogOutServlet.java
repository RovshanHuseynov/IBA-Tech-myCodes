package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class LogOutServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final Database db;

    public LogOutServlet(TemplateEngine engine, Database db) {
        this.engine = engine;
        this.db = db;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LogOut doGet");
        Cookie[] cookies = req.getCookies(); // NULL
        int id = -1; // no user
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("%CALC%")) {
                    c.setMaxAge(0);
                    resp.addCookie(c);
                    //User loggedInUser = db.select_from_one_user(Integer.parseInt(c.getValue()));
                    User loggedInUser = null;
                    HashMap<String, Object> data = new HashMap<>();
                    data.put("user" , loggedInUser);
                    engine.render("logout_Logged.ftl", data, resp);
                }
            }
        }

        Path path = Paths.get("./content/template/logout_Logged.ftl");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LogOut doPost");
    }
}
