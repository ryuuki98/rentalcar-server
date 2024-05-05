package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.DBManager;
import rentalcarServer.PasswordCrypto;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT user_id, user_name, user_birth, user_telecom, user_phone, admin, user_password FROM users WHERE user_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				String birth = rs.getString(3);
				String telecom = rs.getString(4);
				String phone = rs.getString(5);
				boolean admin = rs.getBoolean(6);
				String encryptedPassword = rs.getString(7);

				if (PasswordCrypto.decrypt(password, encryptedPassword))
					user = new UserResponseDto(id, password, name, birth, telecom, phone, admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return user;
	}

	public UserResponseDto createUser(UserRequestDto userDto) {
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO users(user_id, user_password, user_name, user_birth, user_telecom, user_phone) VALUES (?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userDto.getUserId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getUserPassword()));
			pstmt.setString(3, userDto.getUserName());
			pstmt.setString(4, userDto.getUserBirth());
			pstmt.setString(5, userDto.getUserTelecom());
			pstmt.setString(6, userDto.getUserPhone());

			pstmt.execute();

			return findUserByIdAndPassword(userDto.getUserId(), userDto.getUserPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public boolean userExists(String id) {
		return findUserById(id) != null;
	}

	public List<UserResponseDto> findUserAll() {
		List<UserResponseDto> list = new ArrayList<UserResponseDto>();

		try {
			conn = DBManager.getConnection();

			// 쿼리할 준비
			String sql = "SELECT user_id,user_password,user_name,user_birth,user_telecom,user_phone,admin FROM users";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작!
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String telecom = rs.getString(5);
				String phone = rs.getString(6);
				boolean admin = rs.getBoolean(7);

				UserResponseDto user = new UserResponseDto(id, password, name, birth, telecom, phone, admin);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private User findUserById(String id) {
		User user = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM users WHERE user_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			/*
			 * String userId, String userPassword, String userName, String userBirth, String
			 * userTelecom, String userPhone, boolean admin, Timestamp regDate, Timestamp
			 * modDate
			 * 
			 */
			if (rs.next()) {
				String userPassword = rs.getString(2);
				String userName = rs.getString(3);
				String userBirth = rs.getString(4);
				String userTelecom = rs.getString(5);
				String userPhone = rs.getString(6);
				boolean admin = rs.getBoolean(7);
				Timestamp regDate = rs.getTimestamp(8);
				Timestamp modDate = rs.getTimestamp(9);

				user = new User(id, userPassword, userName, userBirth, userTelecom, userPhone, admin, regDate, modDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return user;
	}

	public UserResponseDto updateUser(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		user = findUserByIdAndPassword(userDto.getUserId(), userDto.getUserPassword());

		if (user == null) {
			return null;
		}
		conn = DBManager.getConnection();

		String sql = "UPDATE users SET user_password = ?, user_name = ? ,user_birth = ? , user_telecom = ?,user_phone = ? WHERE user_id = ?";
		try {
			
			System.out.println("id : " + userDto.getUserId());
			System.out.println("password : " + userDto.getUserPassword());
			System.out.println("newpassword : " + newPassword);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PasswordCrypto.encrypt(newPassword));
			pstmt.setString(2, userDto.getUserName());
			pstmt.setString(3, userDto.getUserBirth());
			pstmt.setString(4, userDto.getUserTelecom());
			pstmt.setString(5, userDto.getUserPhone());
			pstmt.setString(6, userDto.getUserId());

			pstmt.execute();
			User userVo = findUserById(userDto.getUserId());
			user = new UserResponseDto(userVo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	public boolean deleteUser(UserRequestDto userDto) {
		conn = DBManager.getConnection();

		String sql = "DELETE FROM users WHERE user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getUserId());

			pstmt.execute();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

		return false;
	}
}