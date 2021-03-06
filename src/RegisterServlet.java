import domain.DataModel;
import domain.Landlord;
import domain.Tenant;

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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private DataModel dataModel;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        dataModel = (DataModel) servletContext.getAttribute("data");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (dataModel != null) {
            String type = request.getParameter("type");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (!username.isEmpty() && !password.isEmpty()) {
                if (!dataModel.userNameExist(username)) {
                    if (type.equals("landlord")) {
                        dataModel.addLandlord(new Landlord(username, password));
                    } else if (type.equals("tenant")) {
                        dataModel.addTenant(new Tenant(username, password));
                    }
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Valid Register</title>");
                    out.println("</head>");
                    out.println("<body bgcolor=\"white\">");
                    out.println("Successful registration, You can <a href=\"register\">Login now</a>");
                    out.println("</body>");
                    out.println("</html>");
                }else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Wrong Username</title>");
                    out.println("</head>");
                    out.println("<body bgcolor=\"white\">");
                    out.println("This username is already exist, You can try <a href=\"register.html\">again");
                    out.println("</body>");
                    out.println("</html>");
                }
            }else {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>INValid Register</title>");
                out.println("</head>");
                out.println("<body bgcolor=\"white\">");
                out.println("Please enter username or password <a href=\"register.html\">Register Again</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
