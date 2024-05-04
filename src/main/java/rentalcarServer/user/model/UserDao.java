package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.DBManager;

public class UserDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
	}

	private static UserDao userDao = new UserDao();

	public static UserDao getInstance() {
		return userDao;
	}
	
	public UserResponseDto createUser(UserRequestDto userDto) {
		DBManager.getConnection();
		UserResponseDto user = null;
		String sql = "INSERT INTO users(user_id,user_password,user_name,user_birth,user_telecom,user_phone) VALUES(?,?,?,?,?,?)";		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getUserId());
			pstmt.setString(2, userDto.getUserPassword());
			pstmt.setString(3, userDto.getUserName());
			pstmt.setString(4, userDto.getUserBirth());
			pstmt.setString(5, userDto.getUserTelecom());
			pstmt.setString(6, userDto.getUserPhone());
			
			pstmt.execute();
			user = findUserByIdAndPassword(userDto.getUserId(),userDto.getUserPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	
		return user;
	}

	private UserResponseDto findUserByIdAndPassword(String userId, String userPassword) {
		UserResponseDto user = null;
		
		return user;
	}
	
	


}
