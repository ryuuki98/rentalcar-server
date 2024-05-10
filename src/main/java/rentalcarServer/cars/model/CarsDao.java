package rentalcarServer.cars.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.DBManager;

public class CarsDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private CarsDao() {
	}

	private static CarsDao carsDao = new CarsDao();

	public static CarsDao getInstance() {
		return carsDao;
	}

	public List<CarsResponseDto> findCarsAll() {
		conn = DBManager.getConnection();
		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM cars";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int carCode = rs.getInt(1);
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				String carSeat = rs.getString(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);

				CarsResponseDto car = new CarsResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				list.add(car);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public List<CarsResponseDto> findAvailableCars(String startDateTime, String endDateTime) {
        List<CarsResponseDto> list = new ArrayList<>();
        conn = DBManager.getConnection();       
        
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        
        try {
            String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM cars WHERE car_code NOT IN" +
                         "(SELECT car_code FROM reservations " +
                         "WHERE ((borrow_date BETWEEN ? AND ?) OR (return_date BETWEEN ? AND ?) OR (borrow_date<= ? AND return_date >= ?)) AND status = '예약중')";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, startDateTime);
            pstmt.setString(2, endDateTime);
            pstmt.setString(3, startDateTime);
            pstmt.setString(4, endDateTime);
            pstmt.setString(5, startDateTime);
            pstmt.setString(6, endDateTime);
         
      
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	int carCode = rs.getInt(1);
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				String carSeat = rs.getString(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);

				CarsResponseDto car = new CarsResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;
    }

	private String findImage(String carName) {
		String url = "/resources/car-images/sonata.jpeg";
		return url;
	}

	public CarsResponseDto findCarsByCarCode(int carCode) {
		conn = DBManager.getConnection();
		CarsResponseDto car = null;
		String sql = "SELECT car_code, car_num, car_abroad,car_brand,car_name,car_type,car_seat,car_oil,car_year,car_price FROM Cars WHERE car_code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String carNum = rs.getString(2);
				String carAbroad = rs.getString(3);
				String carBrand = rs.getString(4);
				String carName = rs.getString(5);
				String carType = rs.getString(6);
				String carSeat = rs.getString(7);
				String carOil = rs.getString(8);
				int carYear = rs.getInt(9);
				int carPrice = rs.getInt(10);
				String imageUrl = findImage(carName);
				car = new CarsResponseDto(carCode, carNum, carAbroad, carBrand, carName, carType,
						carSeat, carOil, carYear, carPrice,imageUrl);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return car;
	}

	
}
