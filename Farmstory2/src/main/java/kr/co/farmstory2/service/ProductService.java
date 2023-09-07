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

	// 상품 등록_productRegister
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	
	public ProductDTO selectProduct(String pNo) {
		return dao.selectProduct(pNo);
	}
	
	// 상품 목록 출력_productList
	public List<ProductDTO> selectProducts(int start) {
		return dao.selectProducts(start);
	}
	public List<ProductDTO> selectProducts(String type, int start) {
		return dao.selectProducts(type, start);
	}
	
	
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	
	public void deleteProduct(String pNo) {
		dao.deleteProduct(pNo);
	}
	
	
	// 추가 
	
	public int selectCountProductsTotal() {
		return dao.selectCountProductsTotal();
	}// for admin
	
	
	public int selectCountProductsTotal(String type) {
		return dao.selectCountProductsTotal(type);
	}
}
