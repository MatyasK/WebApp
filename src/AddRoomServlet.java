import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        int roomnumber = Integer.parseInt(request.getParameter("roomnumber"));
        int squaremeter = Integer.parseInt(request.getParameter("sqmeters"));
        double price = Double.parseDouble(request.getParameter("price"));



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
