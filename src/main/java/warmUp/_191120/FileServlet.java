package warmUp._191120;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String fileName = "content/html/myFile.html";
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        while ((line = br.readLine()) != null) {
            for(int i=0; i<line.length(); i++){
                if(line.charAt(i) == '%') writer.print(req.getPathInfo().substring(1));
                else writer.print(line.charAt(i));
            }
            writer.println();
        }

        br.close();
        writer.close();
    }
}
