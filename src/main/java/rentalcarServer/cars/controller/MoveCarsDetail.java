package rentalcarServer.cars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.cars.model.CarsDao;
import rentalcarServer.cars.model.CarsResponseDto;

/**
 * Servlet implementation class MoveCarsDetail
 */
public class MoveCarsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoveCarsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarsDao carsDao = CarsDao.getInstance();
		int carCode =Integer.parseInt(request.getParameter("carCode")) ;
		CarsResponseDto car = carsDao.findCarsByCarCode(carCode);
		HttpSession session = request.getSession();
		session.setAttribute("car", car);
		response.sendRedirect("/carsDetail");
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
