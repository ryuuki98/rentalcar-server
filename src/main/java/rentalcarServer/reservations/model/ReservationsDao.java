package rentalcarServer.reservations.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import rentalcarServer.DBManager;
import rentalcarServer.cars.model.CarsResponseDto;

public class ReservationsDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReservationsDao() {
		// TODO Auto-generated constructor stub
	}
	private static ReservationsDao reservationsDao = new ReservationsDao();
	
	public static ReservationsDao getInstance() {
		return reservationsDao;
	}
	
	public ReservationsResponseDto createReservation(ReservationsRequestDto reservationsRequestDto) {
		ReservationsResponseDto reservation = null;
		conn = DBManager.getConnection();
		
		String sql = "INSERT INTO reservations (user_id,car_code,car_price,borrow_date,return_date) VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, reservationsRequestDto.getUserId());
			pstmt.setInt(2, reservationsRequestDto.getCarCode());
			pstmt.setInt(3, reservationsRequestDto.getCarPrice());
			pstmt.setTimestamp(4, reservationsRequestDto.getBorrowDate());
			pstmt.setTimestamp(5, reservationsRequestDto.getReturnDate());
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int reservationNum = rs.getInt(1);
				System.err.println(reservationNum);
				reservation = findReservationByReservationNum(reservationNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return reservation;
	}

	private ReservationsResponseDto findReservationByReservationNum(int reservationNum) {
		conn = DBManager.getConnection();
		ReservationsResponseDto reservationsResponseDto = null;
		String sql = "SELECT reservation_num,user_id,car_code,car_price,borrow_date,return_date,status FROM reservations WHERE reservation_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservationNum);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int reservation_num = rs.getInt(1);
				String userId = rs.getString(2);
				int carCode = rs.getInt(3);
				int carPrice = rs.getInt(4);
				Timestamp borrowDate = rs.getTimestamp(5);
				Timestamp returnDate = rs.getTimestamp(6);
				String status = rs.getString(7);
				
				reservationsResponseDto = new ReservationsResponseDto(reservationNum, userId, carCode, carPrice, borrowDate, returnDate, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationsResponseDto;
	}
	
	
}
