package web.calc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

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
        Optional.empty();
        return ans;
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.printf("Calculator:%s", calc(
                req.getParameter("x"),
                req.getParameter("y"),
                req.getParameter("op")
        ));
        writer.close();
    }
}