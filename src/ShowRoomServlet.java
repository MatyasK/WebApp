import users.Landlord;

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
 * Created by Ramon on 9/2/2016.
 */
@WebServlet("/ShowRoomServlet")
public class ShowRoomServlet extends HttpServlet {
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();


        ArrayList<Room> rooms = dataModel.getRooms();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Succes Register</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Room number</th>");
        out.println("<th>Rented </th>");
        out.println("<th>Price </th>");
        out.println("<th>City </th>");
        out.println("</tr");

        boolean landlordHasRoom = false;
        for (Room room : rooms) {
            if (room.getLandlord() == session.getAttribute("username")) {
                out.println("<tr>");
                out.println("<td>" + room.getRoomNumber() + "</td>");
                out.println("<td>" + room.isRentStatus() + "</td>");
                out.println("<td>" + room.getPrice()+ "</td>");
                out.println("<td>" + room.getCity() + "</td>");

                out.println("</tr>");
                landlordHasRoom = true;
            }
        }
        if (landlordHasRoom = false){
            out.println("sorry you don't have room yet!");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("<a href=\"addroom.html\">You can add new Room Here</a>");
        out.println("</body>");

        out.println("</html>");

    }
}
