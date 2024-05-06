package rentalcarServer.board.model;

import java.sql.Timestamp;

public class BoardRequestDto {
	private int boardCode;
    private String userId;
    private String title;
    private String content;
    private boolean admin;
    
    public BoardRequestDto() {
		// TODO Auto-generated constructor stub
	}
    
	public BoardRequestDto(int boardCode, String userId, String title, String content, boolean admin) {
		super();
		this.boardCode = boardCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.admin = admin;
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

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
   
}
