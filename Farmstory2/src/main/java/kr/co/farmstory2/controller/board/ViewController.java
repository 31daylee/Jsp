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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.service.ArticleService;

@WebServlet("/board/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArticleService service = ArticleService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    public ViewController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		String no = request.getParameter("no");
		
		logger.debug("group..." + group);
		logger.debug("cate..." + cate);
		logger.debug("no..." + no);
		
		
		// 글 조회
		ArticleDTO dto = service.selectArticle(no);
		
		List<ArticleDTO> comments = service.selectComments(no);
		logger.debug("comments..." + comments);
		
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		request.setAttribute("no", no);
		request.setAttribute("dto", dto);
		request.setAttribute("comments", comments);
		logger.debug("dto..." + dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
