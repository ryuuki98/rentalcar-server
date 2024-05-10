package rentalcarServer.reservations.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
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

		String sql = "INSERT INTO reservations (user_id,car_code,car_price,borrow_date,return_date,car_name) VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, reservationsRequestDto.getUserId());
			pstmt.setInt(2, reservationsRequestDto.getCarCode());
			pstmt.setInt(3, reservationsRequestDto.getCarPrice());
			pstmt.setTimestamp(4, reservationsRequestDto.getBorrowDate());
			pstmt.setTimestamp(5, reservationsRequestDto.getReturnDate());
			pstmt.setString(6, reservationsRequestDto.getCarName());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int reservationNum = rs.getInt(1);
				reservation = findReservationByReservationNum(reservationNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return reservation;
	}

	public ReservationsResponseDto findReservationByReservationNum(int reservationNum) {
		conn = DBManager.getConnection();
		ReservationsResponseDto reservationsResponseDto = null;
		String sql = "SELECT reservation_num,user_id,car_code,car_price,borrow_date,return_date,status,car_name FROM reservations WHERE reservation_num = ?";
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
				String carName = rs.getString(8);

				reservationsResponseDto = new ReservationsResponseDto(reservationNum, userId, carCode, carPrice,
						borrowDate, returnDate, status, carName);
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
			String sql = "SELECT COUNT(*) FROM reservations " + "WHERE car_code = ? AND "
					+ "((borrow_date <= ? AND return_date >= ?) OR " + "(borrow_date BETWEEN ? AND ?) OR "
					+ "(return_date BETWEEN ? AND ?))AND status = '예약중'";
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
			} else {
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

	public List<ReservationsResponseDto> findReservationsById(String userId) {
		List<ReservationsResponseDto> reservationList = new ArrayList<ReservationsResponseDto>();

		conn = DBManager.getConnection();
		String sql = "SELECT reservation_num,user_id,car_code,car_price,borrow_date,return_date,status,car_name FROM reservations WHERE user_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int reservation_num = rs.getInt(1);
				int carCode = rs.getInt(3);
				int carPrice = rs.getInt(4);
				Timestamp borrowDate = rs.getTimestamp(5);
				Timestamp returnDate = rs.getTimestamp(6);
				String status = rs.getString(7);
				String carName = rs.getString(8);

				ReservationsResponseDto reservationsResponseDto = new ReservationsResponseDto(reservation_num, userId,
						carCode, carPrice, borrowDate, returnDate, status, carName);
				reservationList.add(reservationsResponseDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reservationList;
	}

	public void cancelReservationByReservationNum(int reservationNum) {
		conn = DBManager.getConnection();
		
		String sql = "UPDATE reservations SET status = '예약취소' WHERE reservation_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservationNum);
			
			pstmt.execute();
			System.out.println("예약취소 완료");
		} catch (SQLException e) {
			System.out.println("예약취소 실패");
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
		
	}

	public void updateReservation(ReservationsResponseDto reservation) {
		conn = DBManager.getConnection();
		
		String sql ="UPDATE reservations SET borrow_date = ? , return_date = ? , car_price = ? WHERE reservation_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, reservation.getBorrowDate());
			pstmt.setTimestamp(2, reservation.getReturnDate());
			pstmt.setInt(3, reservation.getCarPrice());
			pstmt.setInt(4, reservation.getReservationNum());
			
			pstmt.execute();
			System.out.println("업데이트 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("업데이트 실패");
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}

	public boolean checkAvailabilityForUpdate(String startDateTime, String endDateTime, String carCode, int reservationNum) {
		conn = DBManager.getConnection();
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM reservations " + "WHERE car_code = ? AND "
					+ "((borrow_date <= ? AND return_date >= ?) OR " + "(borrow_date BETWEEN ? AND ?) OR "
					+ "(return_date BETWEEN ? AND ?))AND status = '예약중' AND reservation_num != ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carCode);
			pstmt.setString(2, startDateTime);
			pstmt.setString(3, endDateTime);
			pstmt.setString(4, startDateTime);
			pstmt.setString(5, endDateTime);
			pstmt.setString(6, startDateTime);
			pstmt.setString(7, endDateTime);
			pstmt.setInt(8, reservationNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			} else {
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
