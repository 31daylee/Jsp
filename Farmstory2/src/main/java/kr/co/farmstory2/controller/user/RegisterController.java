package kr.co.farmstory2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.dto.UserDTO;
import kr.co.farmstory2.service.UserService;

@WebServlet("/user/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = UserService.INSTANCE;
       
    public RegisterController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/register.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uid = request.getParameter("uid");
		String pass1  = request.getParameter("pass1");
		String pass2  = request.getParameter("pass2");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String hp = request.getParameter("hp");
		String zip = request.getParameter("zip");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String regip = request.getRemoteAddr();
		
		UserDTO dto = new UserDTO();
		dto.setUid(uid);
		dto.setPass(pass1);
		dto.setName(name);
		dto.setNick(nick);
		dto.setEmail(email);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setRegip(regip);
		
		service.insertUser(dto);
		
		response.sendRedirect("/Farmstory2/user/login.do?success=300");
		
	}

}
