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
	
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	
	public ProductDTO selectProduct(String pNo) {
		return dao.selectProduct(pNo)
				;
	}
	public List<ProductDTO> selectProducts() {
		
		return dao.selectProducts();
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	
	public void deleteProduct(String pNo) {
		dao.deleteProduct(pNo);
	}
}
