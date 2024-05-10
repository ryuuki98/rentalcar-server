package rentalcarServer.reservations.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.reservations.model.ReservationsDao;

import java.util.List;

public class CheckReservationForUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String startDateTime = request.getParameter("startDateTime");
        String endDateTime = request.getParameter("endDateTime");
        String carCode = request.getParameter("carCode");
        int reservationNum = Integer.parseInt(request.getParameter("reservationNum"));

        ReservationsDao reservationsDao = ReservationsDao.getInstance();
        boolean isAvailable = reservationsDao.checkAvailabilityForUpdate(startDateTime, endDateTime, carCode,reservationNum);

        if (isAvailable) {
            response.getWriter().write("available");
        } else {
            response.getWriter().write("not available");
        }
    }
    
    
}
