import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ArrayList<Room> rooms = dataModel.getRooms();
        if (dataModel != null){
            out.println("<html>");
            out.println("<head>");
            out.println("<title>available rooms</title>");
            out.println("</head>");
            out.println("<body bgcolor=\"white\">");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>number</th>");
            out.println("</tr");
            int minimumsquarematers = Integer.valueOf(request.getParameter("minsquare"));
            int maximumprice = Integer.valueOf(request.getParameter("maxprice"));
            String city = request.getParameter("city");

            for (Room room : rooms) {
                if (room.isRentStatus() == true && room.getPrice() <= maximumprice && room.getSquaremeter() >= minimumsquarematers && room.getCity() == city){
                    out.println("<tr>");
                    out.println("<td>" + room.getRoomNumber() + "</td>");
                    out.println("</tr>");

                }
            }
            out.println("</table>");
            out.println("<br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}