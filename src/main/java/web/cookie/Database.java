package web.cookie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Connection conn;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Database";
    private static final String USERNAME = "postgres";
    private static final String USER_PASS = "1111";

    public Database() {
        conn = getConnection();
    }

    public void insert_into_calculator(String... args) throws SQLException {
        final String SQLI = "INSERT INTO calculator (par1, par2, op, answer, userid) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt_insert = conn.prepareStatement(SQLI);
        String par1 = args[0];
        String par2 = args[1];
        String op = args[2];
        String answer = args[3];
        String userID = args[4];

        stmt_insert.setString(1, par1);
        stmt_insert.setString(2, par2);
        stmt_insert.setString(3, op);
        stmt_insert.setString(4, answer);
        stmt_insert.setInt(5, Integer.parseInt(userID));
        stmt_insert.execute();
    }

    public void insert_into_users(String... args) throws SQLException {
        final String SQLI = "INSERT INTO users (name, password) values (?, ?)";
        PreparedStatement stmt_insert = conn.prepareStatement(SQLI);
        String name = args[0];
        String password = args[1];

        stmt_insert.setString(1, name);
        stmt_insert.setString(2, password);
        stmt_insert.execute();
    }

    public List<User> select_all_from_users() throws SQLException {
        String SQLS = "select * from users";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet outcome = stmt.executeQuery();
        List<User> users = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String name = outcome.getString("name");
            String password = outcome.getString("password");
            User user = new User(id, name, password);
            users.add(user);
        }
        return users;
    }

    public User select_one_user_from_users(int id) throws SQLException {
        String SQLS = "select * from users where id=" + id;
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet outcome = stmt.executeQuery();
        User user = null;
        while (outcome.next()) {
            if (outcome.getInt("id") == id) {
                int idd = outcome.getInt("id");
                String name = outcome.getString("name");
                String password = outcome.getString("password");
                return new User(idd, name, password);
            }
        }
        return null;
    }

    public List<CalculatorEntity> select_all_from_calculator() throws SQLException {
        String SQLS = "select * from calculator";
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet outcome = stmt.executeQuery();
        List<CalculatorEntity> history = new ArrayList<>();
        while (outcome.next()) {
            int id = outcome.getInt("id");
            String par1 = outcome.getString("par1");
            String par2 = outcome.getString("par2");
            String op = outcome.getString("op");
            String answer = outcome.getString("answer");
            int userID = outcome.getInt("userid");
            CalculatorEntity calc1 = new CalculatorEntity(id, par1, par2, op, answer, userID);
            history.add(calc1);
        }
        return history;
    }

    public List<CalculatorEntity> select_all_accordingToUserId_from_calculator(int id) throws SQLException {
        String SQLS = "select * from calculator where userid=" + id;
        PreparedStatement stmt = conn.prepareStatement(SQLS);
        ResultSet outcome = stmt.executeQuery();
        List<CalculatorEntity> history = new ArrayList<>();
        while (outcome.next()) {
            if (outcome.getInt("id") == id) {
                int idd = outcome.getInt("id");
                String par1 = outcome.getString("par1");
                String par2 = outcome.getString("par2");
                String op = outcome.getString("op");
                String answer = outcome.getString("answer");
                int userID = outcome.getInt("userid");
                CalculatorEntity calc1 = new CalculatorEntity(idd, par1, par2, op, answer, userID);
                history.add(calc1);
            }
        }
        return history;
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
            } catch (SQLException e) {
                throw new RuntimeException("Something went wrong during connection", e);
            }
        }
        return conn;
    }
}
