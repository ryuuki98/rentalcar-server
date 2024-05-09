package rentalcarServer.reservations.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.cars.model.CarsResponseDto;
import rentalcarServer.reservations.model.ReservationsRequestDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class MoveReservationFormAction
 */
public class MoveReservationFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoveReservationFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String borrowDateString = request.getParameter("start-datetime");
		String returnDateString = request.getParameter("end-datetime");

		// borrowDateString과 returnDateString를 Timestamp로 변환
		Timestamp borrowDate = Timestamp.valueOf(borrowDateString.replace("T", " ") + ":00");
		Timestamp returnDate = Timestamp.valueOf(returnDateString.replace("T", " ") + ":00");
		
		
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		System.out.println(user.getUserName());
		CarsResponseDto car = (CarsResponseDto) session.getAttribute("car");
		System.out.println(car.getCarCode());
		
		ReservationsRequestDto reservationsRequestDto = new ReservationsRequestDto();
	}

}
