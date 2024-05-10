package rentalcarServer.reservations.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.reservations.model.ReservationsDao;
import rentalcarServer.reservations.model.ReservationsResponseDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class MyReservationAction
 */
public class MyReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyReservationAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReservationsDao reservationsDao = ReservationsDao.getInstance();
		HttpSession session = request.getSession();

		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		String userId = user.getUserId();

		List<ReservationsResponseDto> reservationList = reservationsDao.findReservationsById(userId);
		if (reservationList == null) {
			System.out.println("예약사항 없음");
			response.sendRedirect("/mypage");
		} else {
			session.setAttribute("myReservationList", reservationList);
			response.sendRedirect("/myReservation");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
