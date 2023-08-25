package controller.user2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.User2DTO;
import service.User2Service;


@WebServlet("/user2/register.do")
public class RegisterController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 싱글톤 enum 클래스로 호출
	private User2Service service = User2Service.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
    public RegisterController2() {
    
    }

	public void init(ServletConfig config) throws ServletException {
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		logger.info("RegisterController2 doGet()...1");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user2/register.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("RegisterController doPost()...1");
		
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String age = request.getParameter("age");
		
		User2DTO dto = new User2DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		logger.info("RegisterController doPost()...1"+dto);
		
		service.insertUser2(dto);
		response.sendRedirect("/Ch10/user2/list.do");
		
		
	}

}
