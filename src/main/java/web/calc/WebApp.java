package web.calc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
        handler.addServlet(new ServletHolder(new CalcServlet()), "/calc/*");
        handler.addServlet(new ServletHolder(new HelloServlet()), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
