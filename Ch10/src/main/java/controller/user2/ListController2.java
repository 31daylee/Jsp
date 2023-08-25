package controller.user2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User2DTO;
import service.User2Service;

@WebServlet("/user2/list.do")
public class ListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User2Service service = User2Service.INSTANCE;
       
    public ListController2() {

    }

    public void init(ServletConfig config) throws ServletException {
	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User2DTO> users = service.selectUser2s();
		
		request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user2/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
