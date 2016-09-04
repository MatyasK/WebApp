import users.Landlord;
import users.Tenant;
import users.User;

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
        if (dataModel != null)
        {
            Boolean validLogin= false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(password)){
                    validLogin = true;
                    if (users.get(i) instanceof Tenant){
                        response.sendRedirect("tenant.html");
                        HttpSession session = request.getSession();
                        session.setAttribute("username",users.get(i));
                    }else if (users.get(i) instanceof Landlord){
                        response.sendRedirect("ShowRoomServlet");
                        HttpSession session = request.getSession();
                        session.setAttribute("username",users.get(i));
                    }
                }
            }
            if (validLogin == false){
                response.sendRedirect("invalidcredentials.html");
            }

        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
