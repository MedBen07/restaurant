package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SerMenuPlat", value = "/SerMenuPlat")
public class ServMenuPlat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String source = "";
        String destination ="";
        source = request.getParameter("source");

        if (source.equals("vins")){

            destination = "/vins.jsp";

        } else if (source.equals("plats")){

            destination = "/plat.jsp";
        }

        RequestDispatcher disp = getServletContext().getRequestDispatcher(destination);
        disp.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
