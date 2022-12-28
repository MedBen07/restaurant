package servlets;

import dao.CommonDAO;
import entities.Plat;
import entities.Vin;
import jakarta.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Chargement", value = "/Chargement")
public class Chargement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("projetSessionRestaurant");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//==========================================================================================================
        CommonDAO commonDAO = new CommonDAO(entityManager);

        HttpSession session = request.getSession();

        List<Plat> listEntrees = commonDAO.recupererListPlatEntree();
        List<Plat> listPoissons = commonDAO.recupererListPlatPoissons();
        List<Plat> listViandes = commonDAO.recupererListPlatViandes();
        List<Plat> listFromages = commonDAO.recupererListPlatFromages();
        List<Plat> listDesserts = commonDAO.recupererListPlatDesserts();

        session.setAttribute("listEntrees", listEntrees);
        session.setAttribute("listPoissons", listPoissons);
        session.setAttribute("listViandes", listViandes);
        session.setAttribute("listFromages", listFromages);
        session.setAttribute("listDesserts", listDesserts);

        List<Vin> toutLesVinsBlanc = commonDAO.recupererListVinBlanc();
        List<Vin> toutLesVinsRouges = commonDAO.recupererListVinRouge();
        List<Vin> toutLesVinsMousseux = commonDAO.recupererListVinMousseux();

        session.setAttribute("toutLesVinsBlanc", toutLesVinsBlanc);
        session.setAttribute("toutLesVinsRouges", toutLesVinsRouges);
        session.setAttribute("toutLesVinsMousseux", toutLesVinsMousseux);

        String destination = "/index.jsp";

        RequestDispatcher disp = request.getRequestDispatcher(destination);
        disp.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
