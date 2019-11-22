package warmUp._191120;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new ByeServlet()), "/bye/*");
        handler.addServlet(new ServletHolder(new HelloServlet()), "/hello/*");
        handler.addServlet(new ServletHolder(new FileServlet()), "/file/*");
        handler.addServlet(FileServletName.class, "/fileName/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}

