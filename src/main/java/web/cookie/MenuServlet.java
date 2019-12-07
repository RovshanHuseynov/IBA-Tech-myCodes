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


public class MenuServlet extends HttpServlet implements MyContants {
    private final TemplateEngine engine;

    public MenuServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Menu doGet");
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
                data.put("message", "Hi, " + curUser.getName() + "!");
                engine.render("menu_ok.ftl", data, resp);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            data.put("message", "Please log in to do any operations");
            engine.render("menu_ok.ftl", data, resp);
        }
    }
}
