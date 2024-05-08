package rentalcarServer.cars.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;

/**
 * Servlet implementation class SearchCarsAction
 */
public class SearchCarsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCarsAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarsDao carsDao = CarsDao.getInstance();
		String startDateTime = request.getParameter("start-datetime");
		String endDateTime = request.getParameter("end-datetime");

		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		list = carsDao.findAvailableCars(startDateTime, endDateTime);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
