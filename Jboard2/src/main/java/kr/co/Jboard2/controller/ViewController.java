package kr.co.Jboard2.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		// 글 조회
		ArticleDTO dto = service.selectArticle(no);
		
		// 댓글 조회
		List<ArticleDTO> comments = service.selectComments(no);
		logger.debug("comments..."+comments);
		
		// VIEW 공유 참조
		request.setAttribute("no", no);
		request.setAttribute("dto", dto);
		request.setAttribute("comments", comments);
		logger.debug("dto..." + dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
		dispatcher.forward(request, response);
		
		
//		Map<String, String> map = new HashMap<String, String>();
//		
//		try {
//			mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
//			Enumeration files = mr.getFileNames();
//			
//			while(files.hasMoreElements()) {
//				
//				
//				String file = (String)files.nextElement();
//				String file_name = mr.getFilesystemName(file);
//				String ofile = mr.getOriginalFileName(file);
//				
//				logger.debug(file_name);
//				logger.debug(ofile);
//				
//				map.put(file_name,ofile);
//				
//			}
//			request.setAttribute("map",map );	
//			
//		}catch(IOException e) {
//			logger.error("uploadFile : "+ e.getMessage());
//		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
