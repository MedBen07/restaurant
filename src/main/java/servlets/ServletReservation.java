package servlets;

import dao.CommonDAO;
import entities.Reservation;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ServletReservation", value = "/ServletReservation")
public class ServletReservation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("projetSessionRestaurant");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String telephone = request.getParameter("telephone");
        int nombrePersonne = Integer.parseInt(request.getParameter("nbrePersonne"));
        String message = request.getParameter("msg");

        Reservation reservation = new Reservation(nom, prenom, email, telephone, date , nombrePersonne, message);
        CommonDAO commonDAO = new CommonDAO(entityManager);
        commonDAO.insert(reservation);

        session.setAttribute("reserv", reservation);



        RequestDispatcher disp = request.getRequestDispatcher("/confirmationReservation.jsp");
        disp.forward(request, response);
    }
}
