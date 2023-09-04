package kr.co.farmstory2.controller.board;

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

@WebServlet("/board/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public ListController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String group = request.getParameter("group");
	        String cate = request.getParameter("cate");

	        logger.debug("group : " + group);
	        logger.debug("cate : " + cate);

	        request.setAttribute("group", group);
	        request.setAttribute("cate", cate);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
