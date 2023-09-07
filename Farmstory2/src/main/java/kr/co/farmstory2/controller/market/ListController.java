package kr.co.farmstory2.controller.market;

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

@WebServlet("/market/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService service = ProductService.INSTANCE;
       

	public ListController() {

	}


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String pg = request.getParameter("pg");
		
		if(type == null){
			type = "0";
		}
		
		// 타입에 따른 리스트 페이지 출력 
		ProductDAO dao = new ProductDAO();
		int total = service.selectCountProductsTotal(type);
		
		// 현재 상품 게시물 Limit 시작
		int start = 0;
		int currentPage = 1;
		int lastPageNum = 0;
		int pageGroupCurrent = 1;
		int pageGroupStart = 1;
		int pageGroupEnd = 0;
		int pageStartNum = 0;
	
	
		
		// 현재 상품 계산
		if(pg != null){
			currentPage  = Integer.parseInt(pg);
		}
		
		// Limit 시작값 계산
		start = (currentPage - 1) * 10;
		
		// 전체 상품 갯수 조회
		total = dao.selectCountProductsTotal(type);
		
		// 페이지 번호 계산
		if(total % 10 == 0){
			lastPageNum = (total/10);
		}else{
			lastPageNum = (total/10) +1 ;
		}
		
		// 상품 그룹 계산
		pageGroupCurrent = (int)Math.ceil(currentPage / 10.0);
		pageGroupStart = (pageGroupCurrent -1) * 10 + 1;
		pageGroupEnd = pageGroupCurrent * 10;
		
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		// 상품 시작번호 계산
		pageStartNum = total - start;

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
		
		logger.debug("ListController... start: "+ start);
		logger.debug("ListController... currentPage: "+ currentPage);
		logger.debug("ListController... total: "+ total);
		logger.debug("ListController... lastPageNum: "+ lastPageNum);
		logger.debug("ListController... pageGroupCurrent: "+ pageGroupCurrent);
		logger.debug("ListController... pageGroupStart: "+ pageGroupStart);
		logger.debug("ListController... pageGroupEnd: "+ pageGroupEnd);
		logger.debug("ListController... pageStartNum: "+ pageStartNum);
		logger.debug("ListController... pg: "+ pg);
		logger.debug("ListController... type: "+ type);
		
	
		List<ProductDTO> products = service.selectProducts(type, start);
		
		logger.debug("products : "+products);
		
		request.setAttribute("products", products);
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/market/list.jsp?type="+type+"&pg="+pg);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
