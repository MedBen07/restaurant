package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "ControleLangue", value = "/ControleLangue")
public class ControleLangue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  // servlet a utiliser pour specifier la langue a utiliser pour la classe Locale

        String langue = request.getParameter("langue");

        HttpSession session = request.getSession();
        session.setAttribute("langue", langue);
        String destination = "/index.jsp";

        RequestDispatcher disp = request.getRequestDispatcher(destination);
        disp.forward(request, response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
