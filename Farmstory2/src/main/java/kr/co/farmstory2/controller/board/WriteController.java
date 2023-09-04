package kr.co.farmstory2.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
