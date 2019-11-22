package web.path;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HidenPath extends HttpServlet {
    AuthService as;

    public HidenPath(AuthService as) {
        this.as = as;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Path path = Paths.get("./content/html/login.html");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("user_name");
        String user_paswd = req.getParameter("user_paswd");
        System.out.println(user_name);
        System.out.println(user_paswd);
        try (PrintWriter w = resp.getWriter()) {
            w.println("HidenServlet.POST");
            if (as.check(user_name, user_paswd)) {
                w.println("Successful");
            } else {
                w.println("Not Successful");
            }
        }
    }
}