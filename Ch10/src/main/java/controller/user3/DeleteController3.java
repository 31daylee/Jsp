package controller.user3;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.User3Service;

@WebServlet("/user3/delete.do")
public class DeleteController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private User3Service service = User3Service.INSTANCE; 
    public DeleteController3() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		service.deleteUser3(uid);
		
		response.sendRedirect("/Ch10/user3/list.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
