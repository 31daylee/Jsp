package kr.co.Jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user/findPass.do")
public class FindPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FindPassController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/findPass.jsp");
		dispatcher.forward(request, response);
	}

	// findPass_
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid"); // findPassChange.do에서 출력하기 위해 이거 하나만 필요 

		HttpSession session = request.getSession(); // 페이지 공유할 시 세션을 통한 uid 공유 
		session.setAttribute("uid", uid);
		
		response.sendRedirect("/Jboard2/user/findPassChange.do"); // get방식으로 전달됨
		
		
	}

}
