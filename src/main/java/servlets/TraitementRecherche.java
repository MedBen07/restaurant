package servlets;

import dao.CommonDAO;
import entities.Vin;
import jakarta.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "TraitementRecherche", value = "/TraitementRecherche")
public class TraitementRecherche extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("projetSessionRestaurant");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        HttpSession session = request.getSession();

        String origine = request.getParameter("origine");
        session.setAttribute("origine", origine);

        CommonDAO commonDAO = new CommonDAO(entityManager);
        List<Vin> listeVin = commonDAO.recupererListVinParPays(origine);

        session.setAttribute("listeVin", listeVin);

        String destionation = "/listeVin.jsp";

        RequestDispatcher disp = getServletContext().getRequestDispatcher(destionation);
        disp.forward(request, response);
    }
}