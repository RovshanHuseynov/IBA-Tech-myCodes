package web.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int op1 = Integer.parseInt(req.getParameter("op1"));
        int op2 = Integer.parseInt(req.getParameter("op2"));
        String op = req.getParameter("op");
        int r = 0;
        switch (op){
            case "plus": r = op1 + op2; break;
            case "minus": r = op1 - op2; break;
            case "mult": r = op1 * op2; break;
            case "div": r = op1 / op2; break;
        }
        resp.getWriter().println(r);
    }
}
