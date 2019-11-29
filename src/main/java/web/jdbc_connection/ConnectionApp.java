package web.jdbc_connection;

import java.sql.Connection;

public class ConnectionApp {
    public static void main(String[] args) {
        Connection conn = web.jdbc.DbConnection.getConnection();
    }
}
