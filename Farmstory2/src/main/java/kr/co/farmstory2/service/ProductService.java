package kr.co.farmstory2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.ProductDAO;
import kr.co.farmstory2.dto.ProductDTO;

public enum ProductService {

	INSTANCE;
	ProductDAO dao = new ProductDAO();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto) {}
	
	public ProductDTO selectProduct(String pNo) {
		return null;
	}
	public List<ProductDTO> selectProducts() {
		
		return null;
	}
	public void updateProduct(ProductDTO dto) {}
	
	public void deleteProduct(String pNo) {}
}
