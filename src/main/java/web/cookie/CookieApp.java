package web.cookie;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CookieApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8084);
        ServletContextHandler handler = new ServletContextHandler();
        TemplateEngine engine = TemplateEngine.folder("./content/template");

        handler.addServlet(LogInServlet.class, "/logIn/*");
        handler.addServlet(LogOutServlet.class, "/logOut/*");
        handler.addServlet(HistoryServlet.class, "/history/*");
        handler.addServlet(CalculateServlet.class, "/calc/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/logIn")), "/*");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
