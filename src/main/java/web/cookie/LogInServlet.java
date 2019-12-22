package web.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LogInServlet extends HttpServlet implements MyContants{
    private final TemplateEngine engine;
    private final Database db;

    public LogInServlet(TemplateEngine engine, Database db) {
        this.engine = engine;
        this.db = db;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("LogIn doGet");
        Map<String, Object> data = new HashMap<>();
        Cookie[] cookies = req.getCookies();
        Optional<Integer> userID = Optional.empty();
        if(cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(COOKIE_NAME)) {
                    userID = Optional.of(Integer.parseInt(c.getValue()));
                }
            }
        }

        if(userID.isPresent()){
            try {
                User curUser = db.select_one_user_from_users(userID.get());
                data.put("message", "Hi, " + curUser.getName() + ". You are already logged in.");
                engine.render("login_ok.ftl", data, resp);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
        else{
            data.put("message", "");
            engine.render("login_error.ftl", data, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("LogIn doPost");
        List<User> users;

        try {
            users = db.select_all_from_users();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

        Optional<User> loggedIn = Optional.empty();
        for (User item : users) {
            if (Integer.toString(item.getId()).equals(req.getParameter("user_id"))) {
                Cookie c = new Cookie(COOKIE_NAME, req.getParameter("user_id"));
                c.setPath("/");
                resp.addCookie(c);
                loggedIn = Optional.of(item);
                break;
            }
        }

        Map<String, Object> data = new HashMap<>();
        if (loggedIn.isPresent()) {
            data.put("message", "Hi, " + loggedIn.get().getName() + ". Nice to see you!");
            engine.render("login_ok.ftl", data, resp);
        }
        else{
            data.put("message", "Something went wrong. Please try again.");
            engine.render("login_error.ftl", data, resp);
        }
    }
}
