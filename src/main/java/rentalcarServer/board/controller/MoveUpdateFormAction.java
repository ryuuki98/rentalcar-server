package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardRequestDto;
import rentalcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class MoveUpdateFormAction
 */
public class MoveUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoveUpdateFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		int boardCode = Integer.parseInt(request.getParameter("boardCode"));

		BoardResponseDto board = boardDao.findBoard(boardCode);
		
		request.setAttribute("board", board);
		response.sendRedirect("/updateBoard");
	}

}
