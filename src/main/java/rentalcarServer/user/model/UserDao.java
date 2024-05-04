package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.DBManager;

public class UserDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	private UserDao() {
	}

	UserDao userDao = new UserDao();

	public UserDao getInstance() {
		return userDao;
	}

	

}
