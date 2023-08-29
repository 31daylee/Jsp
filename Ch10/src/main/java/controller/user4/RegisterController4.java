package controller.user4;

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

import dto.User4DTO;
import service.User4Service;

@WebServlet("/user4/register.do")
public class RegisterController4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User4Service service = User4Service.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
       
    public RegisterController4() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user4/register.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		
		User4DTO dto = new User4DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
				
				
		service.insertUser4(dto);
		response.sendRedirect("/Ch10/user4/list.do");
		
		
		
	}

}
