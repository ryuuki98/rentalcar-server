package rentalcarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.user.model.User;
import rentalcarServer.user.model.UserDao;
import rentalcarServer.user.model.UserRequestDto;
import rentalcarServer.user.model.UserResponseDto;



/**
 * Servlet implementation class DeleteFormAction
 */
public class DeleteFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFormAction() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		UserResponseDto loginUser = (UserResponseDto)session.getAttribute("user");
		String id = loginUser.getUserId();

		UserResponseDto user = userDao.findUserByIdAndPassword(id, password);

		if (user == null) {
			System.out.println("비밀번호가 틀렸습니다");
			response.sendRedirect("/mypage");
		} else {
			UserRequestDto userRequestDto = new UserRequestDto();
			userRequestDto.setUserId(id);;
			userDao.deleteUser(userRequestDto);
			session.removeAttribute("user");
			response.sendRedirect("/login");
		}
	}

}
