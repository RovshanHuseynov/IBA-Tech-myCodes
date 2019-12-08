package web.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class HistoryServlet extends HttpServlet implements MyContants{
    private final TemplateEngine engine;

    public HistoryServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("History doGet");
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
                List<CalculatorEntity> lce = db.select_all_accordingToUserId_from_calculator(userID.get());
                List<CalculatorEntityTemp> lcet = new ArrayList<>();
                for(CalculatorEntity item : lce){
                    lcet.add(new CalculatorEntityTemp(item.getPar1(), item.getPar2(), item.getOp(), item.getAnswer()));
                }
                data.put("message", curUser.getName() + "'s History");
                data.put("datas", lcet);
                engine.render("history_ok.ftl", data, resp);
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            data.put("message", "You must log in before seeing history");
            engine.render("history_error.ftl", data, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("History doPost");
    }
}
