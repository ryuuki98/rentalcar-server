package rentalcarServer.reservations.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.reservations.model.ReservationsDao;

/**
 * Servlet implementation class DeleteReservationAction
 */
public class DeleteReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReservationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationsDao reservationsDao = ReservationsDao.getInstance();
		int reservationNum = Integer.parseInt(request.getParameter("reservationNum")); 
		
		reservationsDao.cancelReservationByReservationNum(reservationNum);
		response.sendRedirect("/myReservationAction");
	}

}
