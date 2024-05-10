package rentalcarServer.reservations.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;
import rentalcarServer.reservations.model.ReservationsDao;
import rentalcarServer.reservations.model.ReservationsResponseDto;

/**
 * Servlet implementation class UpdateReservationAction
 */
public class UpdateReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReservationAction() {
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
		CarsDao carsDao = CarsDao.getInstance();
		
		int reservationNum = Integer.parseInt(request.getParameter("reservationNum"));
		ReservationsResponseDto reservation = reservationsDao.findReservationByReservationNum(reservationNum);
		int carCode = reservation.getCarCode();
		
		CarsResponseDto cars = carsDao.findCarsByCarCode(carCode);
		int carPrice = cars.getCarPrice();
		
		String borrowDateString = request.getParameter("start-datetime");
		String returnDateString = request.getParameter("end-datetime");
		
		System.out.println(borrowDateString);
		System.out.println(returnDateString);

		// borrowDateString과 returnDateString를 Timestamp로 변환
		Timestamp borrowDate = Timestamp.valueOf(borrowDateString.replace("T", " ") + ":00");
		Timestamp returnDate = Timestamp.valueOf(returnDateString.replace("T", " ") + ":00");

		long timeLong = ((returnDate.getTime() - borrowDate.getTime()) / (1000 * 60 * 60 ));
		int time = (int) timeLong;
		
		int totalPrice = carPrice * time;
		
		reservation.setBorrowDate(borrowDate);
		reservation.setReturnDate(returnDate);
		reservation.setCarPrice(totalPrice);
		
		reservationsDao.updateReservation(reservation);
		response.sendRedirect("/myReservationAction");
		
		
	}

}
