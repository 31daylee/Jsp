package kr.co.farmstory2.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.FileService;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArticleService aService = ArticleService.INSTANCE;
	private FileService fService = FileService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    public DeleteController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 글 번호 수신
		String no = request.getParameter("no");
		String group = request.getParameter("group");
        String cate = request.getParameter("cate");
        int result = fService.deleteFile(no);
		
		logger.debug("no..." + no);
		request.setAttribute("no", no);
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		aService.deleteArticle(no);
		
		if(result > 0) {
			//파일 경로 구하기
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath("/upload");
			
			File file = new File(path+"/"+"파일명");
			
			if(file.exists()) {
				file.delete();
			}
		}
		response.sendRedirect("/Farmstory2/board/list.do?group="+group+"&cate="+cate);
		
		
	}


}
