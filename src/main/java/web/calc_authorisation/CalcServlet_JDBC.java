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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalcServlet_JDBC extends HttpServlet {
    Connection conn;
    DaoUser daoUser;
    User user;

    public CalcServlet_JDBC(DaoUser daoUser) {
        this.conn = DbConnection.getConnection();
        this.daoUser = daoUser;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        int userId = Integer.parseInt(req.getParameter("user_id"));
        String userName = req.getParameter("user_name");
        String userPassword = req.getParameter("user_paswd");
        user = new User(userId, userName, userPassword);
        try (PrintWriter w = resp.getWriter()) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
            if (daoUser.contains(user)) {
                w.printf("Successful\n");
                String par1 = req.getParameter("x");
                String par2 = req.getParameter("y");
                String op = req.getParameter("op");
                String answer = calc(par1, par2, op);
                w.printf("%s %s %s = %s\n", par1, op, par2, answer);
                try {
                    save(par1, par2, op, answer, user.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                List<String> history = show(user);

                w.println("\n\n\nUser --> " + user.getName());
                w.println("\nHistory");
                w.println("-----------------------");

                for(String item : history){
                    w.println(item);
                }

                w.close();


            } else {
                w.println("Not Successful");
                w.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        Path path = Paths.get("./content/html/login.html");
        ServletOutputStream os = resp.getOutputStream();
        Files.copy(path, os);

        String par1 = req.getParameter("x");
        String par2 = req.getParameter("y");
        String op = req.getParameter("op");
        System.out.printf("x=%s, y=%s, op=%s\n", par1, par2, op);
        String answer = calc(par1, par2, op);
        System.out.printf("answer=%s\n", answer);
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

    public List<String> show(User user) throws SQLException, IOException {
        List<String> history = new ArrayList<>();
        final String SQLS = "SELECT * FROM calculator";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet rset = stmt.executeQuery();
        // processing data
        while (rset.next()) {
            if (user.getId() == rset.getInt("userid")) {
                String line = String.format("par1: %s, op: %s, par2: %s, answer: %s, userId: %d",
                        rset.getString("par1"),
                        rset.getString("op"),
                        rset.getString("par2"),
                        rset.getString("answer"),
                        rset.getInt("userid"));
                System.out.println(line);
                history.add(line);
            }
        }
        return history;
    }
}
