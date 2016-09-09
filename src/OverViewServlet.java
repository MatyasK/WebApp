import users.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Matyas on 9/5/2016.
 */
@WebServlet("/OverViewServlet")
public class OverViewServlet extends HttpServlet {
    private DataModel dataModel;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        dataModel = (DataModel) servletContext.getAttribute("data");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        Cookie[] cookies = req.getCookies();
        String numberOfvisits = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("visits")) {
                numberOfvisits = cookie.getValue();
            }
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ArrayList<User> users = dataModel.getUsers();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>OverView</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("Number of visits: " + numberOfvisits);
        out.println("<br>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Username</th>");
        out.println("</tr");


        for (User user : users) {
                out.println("<tr>");
                out.println("<td>" + user.getUserName() + "</td>");
                out.println("</tr>");
        }
        out.println("</table>");
        out.println("<a href=\"LogoutServlet\">Logout</a>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
