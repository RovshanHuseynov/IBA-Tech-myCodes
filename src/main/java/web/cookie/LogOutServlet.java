package web.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LogOutServlet extends HttpServlet implements MyContants {
    private final TemplateEngine engine;
    private final Database db;

    public LogOutServlet(TemplateEngine engine, Database db) {
        this.engine = engine;
        this.db = db;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("LogOut doGet");
        Map<String, Object> data = new HashMap<>();
        Cookie[] cookies = req.getCookies();
        Database db = new Database();
        Optional<Integer> userID = Optional.empty();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIE_NAME)) {
                    userID = Optional.of(Integer.parseInt(c.getValue()));
                }
            }
        }

        if (userID.isPresent()) {
            try {
                User curUser = db.select_one_user_from_users(userID.get());
                data.put("message", "Current user is " + curUser.getName());
                engine.render("logout_ok.ftl", data, resp);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            data.put("message", "No user logged in!");
            engine.render("logout_error.ftl", data, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("LogOut doPost");
        Cookie c = new Cookie(COOKIE_NAME, "");
        c.setMaxAge(0);
        resp.addCookie(c);

        Map<String, Object> data = new HashMap<>();
        data.put("message", "Succesfully logged out");
        engine.render("logout_error.ftl", data, resp);
    }
}
