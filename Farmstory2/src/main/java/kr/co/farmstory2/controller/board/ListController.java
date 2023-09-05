package kr.co.farmstory2.controller.board;

import java.io.IOException;
import java.util.List;

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

import kr.co.farmstory2.dao.ArticleDAO;
import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.UserDTO;
import kr.co.farmstory2.service.ArticleService;


@WebServlet("/board/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;   
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public ListController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			String group = request.getParameter("group");
	        String cate = request.getParameter("cate");
	    	// 페이지 가져오기 
			String pg = request.getParameter("pg");
			String search = request.getParameter("search");
			
	        logger.debug("group : " + group);
	        logger.debug("cate : " + cate);
	        logger.debug("pg : " + pg);
	        logger.debug("search : " + search);


			// DAO 객체 생성
			ArticleDAO dao = new ArticleDAO();
			
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
			total = service.selectCountTotal(cate);
			
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
	        request.setAttribute("group", group);
	        request.setAttribute("cate", cate);
		
		
	        List<ArticleDTO> articles = service.selectArticles(start,cate);
	        logger.debug("articles.."+articles);
	        
	        request.setAttribute("articles", articles);
	        
	        // 회원만 글 작성 가능하게 세션 정보 확인 
	        HttpSession session = request.getSession();
			UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");
			
			if(sessUser != null) { 
				RequestDispatcher dispatcher = request.getRequestDispatcher("/board/list.jsp");
				dispatcher.forward(request, response);
			}else {
			  response.sendRedirect("/Farmstory2/user/login.do?success=101"); }
	        
	        
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
