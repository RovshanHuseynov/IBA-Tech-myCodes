package web.path;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler();
        AuthService as = new AuthService();
        handler.addServlet(new ServletHolder(new HidenPath(as)), "/hiden/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}