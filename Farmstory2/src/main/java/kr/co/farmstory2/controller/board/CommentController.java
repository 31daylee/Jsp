package kr.co.farmstory2.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.FileService;

@WebServlet("/board/comment.do")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public CommentController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kind = request.getParameter("kind");
		String no = request.getParameter("no");
		String content = request.getParameter("content");
		
		// result 선언 
		int result = 0;
		
		switch(kind) {
		
			case "REMOVE":
				// return 된 result값을 이용 
				result = service.deleteComment(no);
				break;
				
			case "MODIFY":
				result = service.updateComment(no,content);
				break;
		}
		
		
		// JSON 출력 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		response.getWriter().print(json);
		
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
		
		
		// Json 출력(AJAX 요청)
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		response.getWriter().print(json);
		
	}

}
