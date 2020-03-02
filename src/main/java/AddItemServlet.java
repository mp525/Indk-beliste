import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "AddItemServlet", urlPatterns = {"/AddItemServlet"})
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vareNavn = request.getParameter("vareNavn");

        HttpSession session = request.getSession();

        if ( ((Set<String>) session.getAttribute("basket")) == null){

            Set<String> basket = new HashSet<>();

            session.setAttribute("basket", basket);

        }

        ((Set<String>) session.getAttribute("basket")).add(vareNavn);

        request.setAttribute("besked", "Her kan du se en oversigt over dine valgte varer:");

        request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
