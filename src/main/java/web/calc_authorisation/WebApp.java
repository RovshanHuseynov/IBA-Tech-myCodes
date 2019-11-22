package web.calc_authorisation;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8083);
        ServletContextHandler handler = new ServletContextHandler();
        DaoUser daoUser = new DaoUser();
        handler.addServlet(new ServletHolder(new CalcServlet_JDBC(daoUser)), "/hiden/jdbc/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}