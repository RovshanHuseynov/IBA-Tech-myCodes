package web.calc_jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CalcServlet_JDBC extends HttpServlet {
    Connection conn;

    public CalcServlet_JDBC() {
        conn = DbConnection.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String par1 = req.getParameter("x");
        String par2 = req.getParameter("y");
        String op = req.getParameter("op");
        String answer = calc(par1, par2, op);
        writer.printf("Calculator:%s", answer);
        writer.close();

        try {
            save(par1, par2, op, answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        Optional.empty();
        return ans;
    }

    public void save(String par1, String par2, String op, String answer) throws SQLException {
        final String SQLI = "INSERT INTO calculator (par1, par2, op, answer) values (?, ?, ?, ?)";
        PreparedStatement stmt_insert = conn.prepareStatement(SQLI);

        stmt_insert.setString(1, par1);
        stmt_insert.setString(2, par2);
        stmt_insert.setString(3, op);
        stmt_insert.setString(4, answer);
        stmt_insert.execute();
    }

    public void show() throws SQLException {
        final String SQLS = "SELECT * FROM calculator";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet rset = stmt.executeQuery();
        // processing data
        while (rset.next()) {
            String line = String.format("id: %d, par1:%s, par2:%s, op:%s, answer:%s",
                    rset.getInt("id"),
                    rset.getInt("par1"),
                    rset.getInt("par2"),
                    rset.getInt("op"),
                    rset.getString("answer"));
            System.out.println("-----------");
            System.out.println(line);
        }
    }
}
