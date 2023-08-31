package kr.co.Jboard2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Jboard2.dao.ArticleDAO;
import kr.co.Jboard2.dto.ArticleDTO;
import kr.co.Jboard2.service.ArticleService;

@WebServlet("/comment.do")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleService service = ArticleService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());   
	
    public CommentController() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parent = request.getParameter("parent");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String regip = request.getRemoteAddr();
		
		ArticleDTO dto = new ArticleDTO();
		dto.setParent(parent);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		int result = service.insertComment(dto);
		if(result >= 1){
			service.updateArticleForComment(parent);
		}
		
		response.sendRedirect("/Jboard2/view.do?no="+parent);
	
	}

}
