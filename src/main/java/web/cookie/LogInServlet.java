package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

public class LogInServlet extends HttpServlet {
    private PrintWriter w;
    private final TemplateEngine engine;
    private final Database db;

    public LogInServlet(TemplateEngine engine, Database db) {
        this.engine = engine;
        this.db = db;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LogIn doGet");
        Path path = Paths.get("./content/template/login_Logged.ftl");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);

        w = resp.getWriter();
        w.println("USER is already logged in");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("LogIn doPost");
        List<User> users;
        try {
            users = db.select_all_from_users();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        boolean isSuccessful = false;
        User loggedIn = null;
        for (User item : users) {
            if (Integer.toString(item.getId()).equals(req.getParameter("user_id"))) {
                System.out.println("successful");
                isSuccessful = true;
                Cookie c = new Cookie("%CALC%", req.getParameter("user_id"));
                c.setPath("/");
                resp.addCookie(c);
                break;
            }
        }

        if (!isSuccessful) {
            System.out.println("not successful");
        }
    }
}
