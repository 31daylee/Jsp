package controller.user4;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.User4Service;

@WebServlet("/user4/delete.do")
public class DeleteController4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User4Service service = User4Service.INSTANCE;  
    
	public DeleteController4() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seq = request.getParameter("seq");
		service.deleteUser4(seq);
		response.sendRedirect("/Ch10/user4/list.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
