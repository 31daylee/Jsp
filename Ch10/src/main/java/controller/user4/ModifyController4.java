package controller.user4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User3DTO;
import dto.User4DTO;
import service.User4Service;

@WebServlet("/user4/modify.do")
public class ModifyController4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User4Service service = User4Service.INSTANCE;
	
	
    public ModifyController4() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seq = request.getParameter("seq");
		
		User4DTO user = service.selectUser4(seq);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user4/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seq = request.getParameter("seq");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		User4DTO dto = new User4DTO();
		
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		dto.setSeq(seq);
		
		service.updateUser4(dto);
		
		response.sendRedirect("/Ch10/user4/list.do");
	}

}
