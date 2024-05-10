package rentalcarServer.reservations.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.reservations.model.ReservationsDao;
import rentalcarServer.reservations.model.ReservationsRequestDto;
import rentalcarServer.reservations.model.ReservationsResponseDto;

/**
 * Servlet implementation class ReservationAction
 */
public class ReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ReservationsRequestDto reservationRequestDto = (ReservationsRequestDto) session.getAttribute("reservation");
		
		ReservationsDao reservationsDao = ReservationsDao.getInstance();
		
		ReservationsResponseDto reservation = reservationsDao.createReservation(reservationRequestDto);
		if (reservation == null) {
			System.out.println("예약실패");
			response.sendRedirect("/index.jsp");
		}else {
			session.setAttribute("reservation", reservation);
			System.out.println("예약성공");
			response.sendRedirect("/reservationResult");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
