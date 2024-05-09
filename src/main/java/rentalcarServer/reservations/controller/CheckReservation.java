package rentalcarServer.reservations.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.reservations.model.ReservationsDao;

import java.util.List;

public class CheckReservation extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청 파라미터에서 대여일, 반납일, 차량 코드 가져오기
        String startDateTime = request.getParameter("startDateTime");
        String endDateTime = request.getParameter("endDateTime");
        String carCode = request.getParameter("carCode");
        
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        System.out.println(carCode);

        // CarsDao를 사용하여 예약 가능 여부 확인
        ReservationsDao reservationsDao = ReservationsDao.getInstance();
        boolean isAvailable = reservationsDao.checkAvailability(startDateTime, endDateTime, carCode);

        // 예약 가능 여부에 따른 응답 전송
        if (isAvailable) {
            response.getWriter().write("available");
        } else {
            response.getWriter().write("not available");
        }
    }
    
    
}
