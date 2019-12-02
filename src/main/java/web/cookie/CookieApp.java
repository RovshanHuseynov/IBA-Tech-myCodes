package web.cookie;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CookieApp {
    // http://localhost:8084/menu
    public static void main(String[] args) throws Exception {
        Server server = new Server(8084);
        ServletContextHandler handler = new ServletContextHandler();
        TemplateEngine engine = TemplateEngine.folder("./content/template");

        Database db = new Database();
        handler.addServlet(new ServletHolder(new MenuServlet(engine)), "/menu");
        handler.addServlet(new ServletHolder(new LogInServlet(engine, db)), "/login");
        handler.addServlet(new ServletHolder(new LogOutServlet(engine, db)), "logout");
        handler.addServlet(new ServletHolder(new CalculateServlet(engine)), "/calc");
        handler.addServlet(new ServletHolder(new HistoryServlet(engine)), "/history");
        handler.addServlet(new ServletHolder(new RedirectServlet("/menu")), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
