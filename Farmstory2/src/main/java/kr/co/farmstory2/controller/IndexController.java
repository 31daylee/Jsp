package kr.co.farmstory2.controller;

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

@WebServlet(value = {"","/index.do"})
public class IndexController extends HttpServlet{
	
    private ArticleService service = ArticleService.INSTANCE;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public IndexController() {

    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<ArticleDTO> latests1 = service.selectLatests("grow", 5);
		List<ArticleDTO> latests2 = service.selectLatests("school", 5);
		List<ArticleDTO> latests3 = service.selectLatests("story", 5);
		
		List<ArticleDTO> tabLatests1 = service.selectLatests("notice", 3);
		List<ArticleDTO> tabLatests2 = service.selectLatests("qna", 3);
		List<ArticleDTO> tabLatests3 = service.selectLatests("faq", 3);
		
		logger.debug("latests1 : "+ latests1);
		logger.debug("latests2 : "+ latests2);
		logger.debug("latests3 : "+ latests3);
		
		request.setAttribute("latests1", latests1);
		request.setAttribute("latests2", latests2);
		request.setAttribute("latests3", latests3);
		request.setAttribute("tabLatests1", tabLatests1);
		request.setAttribute("tabLatests2", tabLatests2);
		request.setAttribute("tabLatests3", tabLatests3);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
