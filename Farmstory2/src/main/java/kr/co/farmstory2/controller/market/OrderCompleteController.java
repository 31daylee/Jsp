package kr.co.farmstory2.controller.market;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.OrderDTO;
import kr.co.farmstory2.service.OrderService;


@WebServlet("/market/orderComplete.do")
public class OrderCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private OrderService service = OrderService.INSTANCE;
	
	
	public OrderCompleteController() {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orderProduct = request.getParameter("orderProduct");
		String orderCount = request.getParameter("orderCount");
		String orderDelivery = request.getParameter("orderDelivery");
		String orderPrice = request.getParameter("orderPrice");
		String orderTotal = request.getParameter("orderTotal");
		String orderUser = request.getParameter("orderUser");
		String receiver = request.getParameter("receiver");
		String hp    = request.getParameter("hp");
		String zip   = request.getParameter("zip");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String etc   = request.getParameter("etc");

		OrderDTO dto = new OrderDTO();
		dto.setOrderProduct(orderProduct);
		dto.setOrderCount(orderCount);
		dto.setOrderDelivery(orderDelivery);
		dto.setOrderPrice(orderPrice);
		dto.setOrderTotal(orderTotal);
		dto.setReceiver(receiver);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setOrderEtc(etc);
		dto.setOrderUser(orderUser);
		logger.debug("OrderController..dto: "+dto.toString());
		
		service.insertOrder(dto);
		
		response.sendRedirect("/Farmstory2/market/list.do?success=400");
	}

}
