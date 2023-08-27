package controller.user2;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.User2Service;

@WebServlet("/user2/delete.do")
public class DeleteController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User2Service service = User2Service.INSTANCE;
	
    public DeleteController2() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		service.deleteUser2(uid);
		response.sendRedirect("/Ch10/user2/list.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
