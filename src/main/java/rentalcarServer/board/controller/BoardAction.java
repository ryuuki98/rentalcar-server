package rentalcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;

public class BoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardResponseDto> list = BoardDao.getInstance().findBoardAll();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		response.sendRedirect("/board");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}