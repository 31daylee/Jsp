package kr.co.farmstory2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.UserDTO;
import kr.co.farmstory2.service.UserService;


@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService service = UserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public LoginController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String success = request.getParameter("success");
		request.setAttribute("success", success);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid  = request.getParameter("uid");
		String pass = request.getParameter("pass");
	
		UserDTO user = service.selectUser(uid,pass);
		
		if(user != null) {
			
			
			// 현재 세션 구하기
			HttpSession session = request.getSession();
		
			// 사용자 세션 설정
			session.setAttribute("sessUser", user);
		
			logger.info(user.toString());
			
			
			// 리다이렉트
			response.sendRedirect("/Farmstory2/");
		}else {
			// 리다이렉트
			response.sendRedirect("/Farmstory2/user/login.do?success=100");
		}
	
	
	}

}
