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
		
		BoardRequestDto board = new BoardRequestDto();
		
		board.setUserId(userId);
		board.setTitle(title);
		board.setContent(content);
		
		boardDao.createBoard(board);
		response.sendRedirect("/boardAction");
	}

}
