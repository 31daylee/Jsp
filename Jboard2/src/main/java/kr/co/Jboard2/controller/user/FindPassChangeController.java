package kr.co.Jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.Jboard2.dto.UserDTO;
import kr.co.Jboard2.service.UserService;


@WebServlet("/user/findPassChange.do")
public class FindPassChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		
		if(uid == null) {
			response.sendRedirect("/Jboard2/user/findPass.do");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user/findPassChange.jsp");
			dispatcher.forward(request, response);
		}
		

	
	
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass1");
		
		service.updateUserPass(uid, pass);
		
		response.sendRedirect("/Jboard2/user/login.do?success=333");
	
	
	}

}
