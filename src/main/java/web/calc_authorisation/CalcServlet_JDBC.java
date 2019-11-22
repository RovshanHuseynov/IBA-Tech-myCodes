package web.calc_authorisation;

import web.calc_jdbc.DbConnection;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CalcServlet_JDBC extends HttpServlet {
    Connection conn;
    DaoUser daoUser;

    public CalcServlet_JDBC(DaoUser daoUser) {
        conn = DbConnection.getConnection();
        this.daoUser = daoUser;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String user_name = req.getParameter("user_name");
        String user_paswd = req.getParameter("user_paswd");
        User user = new User(user_id, user_name, user_paswd);

        try (PrintWriter w = resp.getWriter()) {
            if (daoUser.contains(user)) {
                w.println("Successful");

                PrintWriter writer = resp.getWriter();
                String par1 = req.getParameter("x");
                String par2 = req.getParameter("y");
                String op = req.getParameter("op");
                String answer = calc(par1, par2, op);
                writer.printf("Calculator:%s", answer);
                writer.close();

                try {
                    save(par1, par2, op, answer, user.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    show(user.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else {
                w.println("Not Successful");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get("./content/html/login.html");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);
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

    public void save(String par1, String par2, String op, String answer, int user_id) throws SQLException {
        final String SQLI = "INSERT INTO calculator (par1, par2, op, answer, userid) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt_insert = conn.prepareStatement(SQLI);

        stmt_insert.setString(1, par1);
        stmt_insert.setString(2, par2);
        stmt_insert.setString(3, op);
        stmt_insert.setString(4, answer);
        stmt_insert.setInt(5, user_id);
        stmt_insert.execute();
    }

    public void show(int user_id) throws SQLException {
        System.out.println("Show");
        final String SQLS = "SELECT * FROM calculator";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet rset = stmt.executeQuery();
        // processing data
        while (rset.next()) {
            if (user_id == rset.getInt("userid")) {
                String line = String.format("id: %d, par1:%s, par2:%s, op:%s, answer:%s, userId:%d",
                        rset.getInt("id"),
                        rset.getString("par1"),
                        rset.getString("par2"),
                        rset.getString("op"),
                        rset.getString("answer"),
                        rset.getInt("userid"));
                System.out.println("-----------");
                System.out.println(line);
            }
        }
    }
}
