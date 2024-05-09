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

	 public boolean checkAvailability(String startDateTime, String endDateTime, String carCode) {
	       conn = DBManager.getConnection();
	       int count = 0;
	        try {
	            String sql = "SELECT COUNT(*) FROM reservations " +
	                           "WHERE car_code = ? AND " +
	                           "((borrow_date <= ? AND return_date >= ?) OR " +
	                           "(borrow_date BETWEEN ? AND ?) OR " +
	                           "(return_date BETWEEN ? AND ?))AND status = '예약중'";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, carCode);
	            pstmt.setString(2, startDateTime);
	            pstmt.setString(3, endDateTime);
	            pstmt.setString(4, startDateTime);
	            pstmt.setString(5, endDateTime);
	            pstmt.setString(6, startDateTime);
	            pstmt.setString(7, endDateTime);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                count = Integer.parseInt(rs.getString(1));
	                System.out.println("count : " + count);
	            }else {
					return true;
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	          DBManager.close(conn, pstmt, rs);
	        }
	        
            return count == 0;
	    }
	
	
}
