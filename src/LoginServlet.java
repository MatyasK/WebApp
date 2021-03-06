import domain.DataModel;
import domain.Landlord;
import domain.Tenant;
import domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

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
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        ArrayList<User> users = dataModel.getUsers();


        if (userName != null && password != null){
            if (dataModel != null)
            {
                Boolean validLogin= false;
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(password)) {
                        validLogin = true;
                        if (users.get(i) instanceof Tenant) {
                            HttpSession session = request.getSession();
                            session.setAttribute("username", users.get(i));
                            request.getRequestDispatcher("WEB-INF/tenant.html").forward(request,response);


                        } else if (users.get(i) instanceof Landlord) {
                            HttpSession session = request.getSession();
                            session.setAttribute("username", users.get(i));
                            response.sendRedirect("ShowRoomServlet");
                        }
                    }
                }
                if (!validLogin){
                    response.sendRedirect("invalidcredentials.html");
                }

            }
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
