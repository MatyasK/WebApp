import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Matyas on 9/2/2016.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private DataModel dataModel;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        dataModel = (DataModel) servletContext.getAttribute("data");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (dataModel != null)
        {

        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
