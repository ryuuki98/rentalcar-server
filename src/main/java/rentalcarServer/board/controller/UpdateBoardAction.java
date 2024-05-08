package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardRequestDto;

/**
 * Servlet implementation class UpdateBoardAction
 */
public class UpdateBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardAction() {
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
		
		int boardCode = Integer.parseInt(request.getParameter("boardCode")) ;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardRequestDto board = new BoardRequestDto();
		
		board.setBoardCode(boardCode);
		board.setTitle(title);
		board.setContent(content);
		
		boardDao.updateBoard(board);
		response.sendRedirect("/detail?boardCode=" + boardCode);
	}

}
