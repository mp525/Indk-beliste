import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null){

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");

            servletContext.setAttribute("brugerMap", brugerMap);

        }
        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)){

            //todo gå til logindside


            request.setAttribute("besked", "brugernavnet findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request,response);



        }

        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)){

            //todo gå til huskelisten
            response.getWriter().println("Klar til login - alt er fint!");
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);

        }

        //todo gå til login dvs. index siden
        request.setAttribute("besked", "din kode var forkert");
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
