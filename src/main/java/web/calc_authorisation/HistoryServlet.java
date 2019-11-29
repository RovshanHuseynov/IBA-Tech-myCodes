package web.calc_authorisation;

import web.calc_jdbc.DbConnection;

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
import java.util.ArrayList;
import java.util.List;

public class HistoryServlet extends HttpServlet {
    Connection conn;

    public HistoryServlet() {
        this.conn = DbConnection.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        String par = req.getParameter("id");
        int userID = (par == null) ? 0 : Integer.parseInt(par);
        PrintWriter w = resp.getWriter();
        w.println("History of " + userID + "\n");

        List<String> history = new ArrayList<>();
        final String SQLS = "SELECT * FROM calculator";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(SQLS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rset = null;
        try {
            rset = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!rset.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String line = null;
            try {
                line = String.format("par1: %s, op: %s, par2: %s, answer: %s, userId: %d",
                        rset.getString("par1"),
                        rset.getString("op"),
                        rset.getString("par2"),
                        rset.getString("answer"),
                        rset.getInt("userid"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (userID == 0 || userID == rset.getInt("userid")) {
                    history.add(line);
                    w.println(line);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
