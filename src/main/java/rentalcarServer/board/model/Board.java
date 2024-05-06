package rentalcarServer.board.model;

import java.sql.Timestamp;

public class Board {
	private int boardCode;
    private String userId;
    private String title;
    private String content;
    private boolean admin;
    private Timestamp regDate;
    private Timestamp modDate;
    
	public Board(int boardCode, String userId, String title, String content, boolean admin, Timestamp regDate,
			Timestamp modDate) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getBoardCode() {
		return boardCode;
	}

	public String getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
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

}
