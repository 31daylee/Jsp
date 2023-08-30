package kr.co.Jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Jboard2.dto.UserDTO;
import kr.co.Jboard2.service.UserService;


@WebServlet("/user/findIdResult.do")
public class FindIdResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = UserService.getInstance();
 
    public FindIdResultController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserDTO user = service.selectUserByNameAndEmail(name, email);
		request.setAttribute("user", user);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/findIdResult.jsp");
		dispatcher.forward(request, response);
	
	}

	
}