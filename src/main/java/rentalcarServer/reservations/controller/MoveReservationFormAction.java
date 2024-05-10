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

		Timestamp borrowDate = Timestamp.valueOf(borrowDateString.replace("T", " ") + ":00");
		Timestamp returnDate = Timestamp.valueOf(returnDateString.replace("T", " ") + ":00");

		long timeLong = ((returnDate.getTime() - borrowDate.getTime()) / (1000 * 60 * 60 ));
		int time = (int) timeLong;
		

		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		CarsResponseDto car = (CarsResponseDto) session.getAttribute("car");
		
		int price = time * car.getCarPrice();

		ReservationsRequestDto reservationsRequestDto = new ReservationsRequestDto();
		reservationsRequestDto.setUserId(user.getUserId());
		reservationsRequestDto.setCarCode(car.getCarCode());
		reservationsRequestDto.setCarPrice(price);
		reservationsRequestDto.setBorrowDate(borrowDate);
		reservationsRequestDto.setReturnDate(returnDate);
		reservationsRequestDto.setCarName(car.getCarBrand() + " "+car.getCarName());		
		session.setAttribute("reservation", reservationsRequestDto);
		response.sendRedirect("/reservationForm");

	}

}
