package kr.co.farmstory2.dao;

import java.util.List;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.dto.OrderDTO;

public class OrderDAO extends DBHelper{

	public void insertOrder(OrderDTO dto) {}
	
	public OrderDTO selectOrder(String orderNo) {
		return null;
	}
	public List<OrderDTO> selectOrders() {
		
		return null;
	}
	public void updateOrder(OrderDTO dto) {}
	
	public void deleteOrder(String orderNo) {}
	
	
}
