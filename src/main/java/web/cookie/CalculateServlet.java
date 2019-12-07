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

public class CalculateServlet extends HttpServlet implements MyContants {
    private final TemplateEngine engine;
    private final Database db;

    public CalculateServlet(TemplateEngine engine, Database db) {
        this.engine = engine;
        this.db = db;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Calculate doGet");
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
                engine.render("calculate_ok.ftl", data, resp);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            data.put("message", "You must log in before calculate operation");
            engine.render("calculate_error.ftl", data, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Calculate doPost");

        String par1 = req.getParameter("x");
        String par2 = req.getParameter("y");
        String op = req.getParameter("op");
        String answer = calc(par1, par2, op);
        String userID = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie c: cookies) {
            if (c.getName().equals(COOKIE_NAME)) {
                userID = c.getValue();
            }
        }
        CalculatorEntity ce = new CalculatorEntity(par1, par2, op, answer, userID);
        System.out.println("." + userID + ".");
        try {
            db.insert_into_calculator(ce);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("message", "Your calculation is successfully finished");
        engine.render("calculate_ok.ftl", data, resp);
    }

    private String calc(String p1, String p2, String op) {
        String ans = "";

        switch (op) {
            case "plus":
                ans = Integer.toString(Integer.parseInt(p1) + Integer.parseInt(p2));
                break;
            case "minus":
                ans = Integer.toString(Integer.parseInt(p1) - Integer.parseInt(p2));
                break;
            case "mult":
                ans = Integer.toString(Integer.parseInt(p1) * Integer.parseInt(p2));
                break;
            case "div":
                ans = Integer.toString(Integer.parseInt(p1) / Integer.parseInt(p2));
                break;
        }

        return ans;
    }
}
