import domain.DataModel;
import domain.Landlord;
import domain.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Created by Ramon on 9/2/2016.
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {

    private DataModel model;
    @Override
    public void init() throws ServletException {
        super.init();
        model = (DataModel) getServletContext().getAttribute("data");


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomnumber = request.getParameter("roomnumber");
        String squaremeter =request.getParameter("sqmeters");
        String price = request.getParameter("price");
        String city = request.getParameter("city");
        HttpSession session = request.getSession(false);

        if ( session == null || session.getAttribute("username") == null ) {
            response.sendRedirect("login.html");
        }else {
            if (model != null) {
                if (!roomnumber.isEmpty() && !squaremeter.isEmpty() && !price.isEmpty() && !city.isEmpty()){
                    int roomNr = Integer.valueOf(roomnumber);
                    int sqm2 = Integer.valueOf(squaremeter);
                    int prce= Integer.valueOf(price);
                    int roomNumbers = model.getRooms().size();
                    model.addRoom(new Room(roomNr, (Landlord) session.getAttribute("username"), sqm2, prce, city, false));
                    if (roomNumbers < model.getRooms().size()) {
                        out.println("Room is added");
                    }
                    response.sendRedirect("ShowRoomServlet");
                }else {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Invalid data</title>");
                    out.println("</head>");
                    out.println("<body bgcolor=\"white\">");
                    out.println("Please fill up every field!, You can try <a href=\"/NewRoomForwardServlet\">again");
                    out.println("</body>");
                    out.println("</html>");
                }

            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
