package rentalcarServer.user.model;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userBirth;
    private String userTelecom;
    private String userPhone;
    private boolean admin;
    private Timestamp regDate;
    private Timestamp modDate;
	public User(String userId, String userPassword, String userName, String userBirth, String userTelecom,
			String userPhone, boolean admin, Timestamp regDate, Timestamp modDate) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTelecom = userTelecom;
		this.userPhone = userPhone;
		this.admin = admin;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public String getUserTelecom() {
		return userTelecom;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public boolean isAdmin() {
		return admin;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public Timestamp getModDate() {
		return modDate;
	}
	

    // 생성자, Getter 및 Setter 메서드는 생략하겠습니다.
    // 필요하다면 추가해주세요.
}
