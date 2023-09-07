package kr.co.farmstory2.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.ProductDAO;
import kr.co.farmstory2.dto.ProductDTO;
import kr.co.farmstory2.service.ProductService;

@WebServlet("/admin/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public ProductListController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String pg = request.getParameter("pg");
		logger.debug("ProductListController...pg : "+pg);	
		
		ProductDAO dao = new ProductDAO();
		

		// 현재 페이지 게시물 Limit 시작
		int start = 0;
		int currentPage = 1;
		int total = 0;
		int lastPageNum = 0;
		int pageGroupCurrent = 1;
		int pageGroupStart = 1;
		int pageGroupEnd = 0;
		int pageStartNum = 0;
		

		// 현재 페이지 계산
		if(pg != null){
			currentPage  = Integer.parseInt(pg);
		}
		
		// Limit 시작값 계산
		start = (currentPage - 1) * 10;
		
		// 전체 게시글 갯수 조회
		total = service.selectCountProductsTotal();
		
		// 페이지 번호 계산
		if(total % 10 == 0){
			lastPageNum = (total/10);
		}else{
			lastPageNum = (total/10) +1 ;
		}
		
		// 페이지 그룹 계산
		pageGroupCurrent = (int)Math.ceil(currentPage / 10.0);
		pageGroupStart = (pageGroupCurrent -1) * 10 + 1;
		pageGroupEnd = pageGroupCurrent * 10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		// 페이지 시작번호 계산
		pageStartNum = total - start;
		
		// JSP페이지에서 사용할 데이터를 request 객체에 설정
		request.setAttribute("start", start);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("total", total);
		request.setAttribute("lastPageNum", lastPageNum);
		request.setAttribute("pageGroupCurrent", pageGroupCurrent);
		request.setAttribute("pageGroupStart", pageGroupStart);
		request.setAttribute("pageGroupEnd", pageGroupEnd);
		request.setAttribute("pageStartNum", pageStartNum);
		request.setAttribute("pg", pg);
		request.setAttribute("type", type);
	
		
		List<ProductDTO> products = service.selectProducts(start);
		logger.debug("ProductList Controller...products1 : "+products);
		
		request.setAttribute("products", products);
		logger.debug("ProductList Controller...products2 : "+products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/productList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
