package rentalcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {
		// TODO Auto-generated constructor stub
	}
	
	private static BoardDao boardDao = new BoardDao();
	
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	public List<BoardResponseDto> findBoardAll(){
		List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
		conn = DBManager.getConnection();
		String sql = "SELECT board_code,user_id,title,content,admin,reg_date FROM board order by reg_date desc;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);
				Timestamp reg_date = rs.getTimestamp(6);
				BoardResponseDto board = new BoardResponseDto(boardCode, userId, title, content, admin, reg_date);
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
	public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
	    conn = DBManager.getConnection();
	    BoardResponseDto board = null;
	    String userId = boardRequestDto.getUserId();
	    String title = boardRequestDto.getTitle();
	    String content = boardRequestDto.getContent();

	    String sql = "INSERT INTO board (user_id, title, content, admin) VALUES (?, ?, ?, (SELECT admin FROM users where user_id = ? ))";

	    try {
	        pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        pstmt.setString(1, userId);
	        pstmt.setString(2, title);
	        pstmt.setString(3, content);
	        pstmt.setString(4, userId);

	        pstmt.executeUpdate();

	        ResultSet rs = pstmt.getGeneratedKeys();
	        if (rs.next()) {
	            int boardId = rs.getInt(1);
	            System.out.println(boardId);
	           board = findBoard(boardId);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
			DBManager.close(conn, pstmt, rs);
		}
	    return board;
	}

	private BoardResponseDto findBoard(int boardId) {
		conn = DBManager.getConnection();
		BoardResponseDto board = null;
		String sql = "SELECT board_code,user_id,title,content,admin FROM board WHERE board_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int boardCode = rs.getInt(1);
				String userId = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				boolean admin = rs.getBoolean(5);
				
				board = new BoardResponseDto(boardCode, userId, title, content, admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return board;
	}

}
