package kr.co.farmstory2.controller.board;

import java.io.IOException;

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

@WebServlet("/board/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    public ModifyController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		String no = request.getParameter("no");
		
		ArticleDTO dto = service.selectArticle(no);
		request.setAttribute("dto", dto);
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		request.setAttribute("no", no);
		
		logger.debug("modifyController.. dto.."+dto);
		logger.debug("modifyController.. group.."+group);
		logger.debug("modifyController.. cate.."+cate);
		logger.debug("modifyController.. no.."+no);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		
		ArticleDTO dto = new ArticleDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		
		service.updateArticle(dto);
		
		response.sendRedirect("/Farmstory2/board/view.do?group="+group+"&cate="+cate+"&no="+no);
		
		
	}

}
