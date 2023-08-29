package controller.user3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User3DTO;
import service.User3Service;

@WebServlet("/user3/register.do")
public class RegisterController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User3Service service = User3Service.INSTANCE;
    public RegisterController3() {

    }

	public void init(ServletConfig config) throws ServletException {

	}
	// 등록 페이지에 대한 요청-응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user3/register.jsp");
		dispatcher.forward(request, response);
	}
	
	// 사용자 정보 입력에 대한 서비스 연결 후 list.do로 리다이렉트 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String age = request.getParameter("age");
		
		User3DTO dto = new User3DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		
		service.insertUser3(dto);
		
		response.sendRedirect("/Ch10/user3/list.do");
	}

}
