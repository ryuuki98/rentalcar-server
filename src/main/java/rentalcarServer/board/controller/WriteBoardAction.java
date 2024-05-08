package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardRequestDto;
import rentalcarServer.board.model.BoardResponseDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class WriteBoardAction
 */
public class WriteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();
		
		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		String userId = user.getUserId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isValid = true;

		if (userId == null || userId.equals(""))
			isValid = false;
		else if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;
		
		if(isValid) {
			BoardRequestDto board = new BoardRequestDto();
			
			board.setUserId(userId);
			board.setTitle(title);
			board.setContent(content);
			
			BoardResponseDto boardResponseDto = boardDao.createBoard(board);
			response.sendRedirect("/detail?boardCode=" + boardResponseDto.getBoardCode());
		}else {
			System.out.println("글이 없거나 제목이 없거나 ");			
			response.sendRedirect("/boardAction");
		}
		
	
	}

}
