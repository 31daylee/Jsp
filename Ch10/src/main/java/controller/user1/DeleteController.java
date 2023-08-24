package controller.user1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.User1Service;

@WebServlet("/user1/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User1Service service = new User1Service();
	
	@Override
	public void init() throws ServletException {
		
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String uid = request.getParameter("uid");

	     service.deleteUser1(uid);

	     response.sendRedirect("/Ch10/user1/list.do");
		
		
	}


}
