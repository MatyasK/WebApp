import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Matyas on 9/4/2016.
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
    private DataModel dataModel;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        dataModel = (DataModel) servletContext.getAttribute("data");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
        } else {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            ArrayList<Room> rooms = dataModel.getRooms();
            if (dataModel != null) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>available rooms</title>");
                out.println("</head>");
                out.println("<body bgcolor=\"white\">");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Room number</th>");
                out.println("<th>Square meters</th>");
                out.println("<th>Price</th>");
                out.println("<th> Landlord Name</th>");
                out.println("<th> City </th>");
                out.println("</tr");
                int minimumsquarematers = Integer.valueOf(request.getParameter("minsquare"));
                int maximumprice = Integer.valueOf(request.getParameter("maxprice"));
                String city = request.getParameter("city");
                System.out.println("square: " + minimumsquarematers + "maxprice: " + maximumprice);
                for (Room room : rooms) {
                    if (room.isRentStatus() && room.getCity().equals(city) && room.getPrice() <= maximumprice && minimumsquarematers >= room.getSquaremeter()) {
                        System.out.println("found without m2");
                        System.out.println("found with m2");
                        out.println("<tr>");
                        out.println("<td>" + room.getRoomNumber() + "</td>");
                        out.println("<td>" + room.getSquaremeter() + "</td>");
                        out.println("<td>" + room.getPrice() + "</td>");
                        out.println("<td>" + room.getLandlord().getUserName() + "</td>");
                        out.println("<td>" + room.getCity() + "</td>");
                        out.println("</tr>");
                    }
                }
                out.println("</table>");
                out.println("<br>");
                out.println("<a href=\"LogoutServlet\">Logout</a>");
                out.println("</body>");
                out.println("</html>");
            }

        }
    }
}
