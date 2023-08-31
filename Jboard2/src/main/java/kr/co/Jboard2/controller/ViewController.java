package kr.co.Jboard2.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Jboard2.dto.ArticleDTO;
import kr.co.Jboard2.service.ArticleService;

@WebServlet("/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public ViewController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		ArticleDTO dto = service.selectArticle(no);
		
		List<ArticleDTO> comments = service.selectComments(no);
		logger.debug("comments..."+comments);
		
		request.setAttribute("dto", dto);
		request.setAttribute("comments", comments);
		logger.debug("dto..." + dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
