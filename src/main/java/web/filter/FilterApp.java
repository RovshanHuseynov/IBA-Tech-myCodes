package web.filter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class FilterApp {
    public static void main(String[] args) throws Exception {

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(CalcServlet.class, "/c/*");
        handler.addFilter(CalcFilter.class, "/c/*", EnumSet.of(DispatcherType.REQUEST));

        Server server = new Server(9002);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
