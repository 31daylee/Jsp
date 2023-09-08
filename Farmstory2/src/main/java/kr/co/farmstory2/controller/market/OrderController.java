package kr.co.farmstory2.controller.market;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.UserDTO;


@WebServlet("/market/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public OrderController() {

	}


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/market/order.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String thumb2   	= request.getParameter("thumb2");
		String pName    	= request.getParameter("pName");
		String pNo      	= request.getParameter("pNo");
		String delivery 	= request.getParameter("delivery");
		String price    	= request.getParameter("price");
		String count    	= request.getParameter("count");
		String total    	= request.getParameter("total");
		String finalPrice   = request.getParameter("final");
	
		
		request.setAttribute("thumb2", thumb2);
		request.setAttribute("pName", pName);
		request.setAttribute("pNo", pNo);
		request.setAttribute("delivery", delivery);
		request.setAttribute("price", price);
		request.setAttribute("count", count);
		request.setAttribute("total", total);
		request.setAttribute("finalPrice", finalPrice);
		
		
		logger.debug("thumb2 : "+thumb2);
		
		// 회원만 글 작성 가능하게 세션 정보 확인 
        HttpSession session = request.getSession();
		UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
		
		if(sessUser != null) { 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/market/order.jsp");
			dispatcher.forward(request, response);
		}else {
		  response.sendRedirect("/Farmstory2/user/login.do?success=101"); }
		
	}

}
