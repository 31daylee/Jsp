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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.FileService;

@WebServlet("/board/write.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    private FileService fService = FileService.INSTANCE;
    
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public WriteController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//파일 경로 구하기
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/upload");
		
		// 최대 업로드 파일 크기
		int maxSize = 1024 * 1024 * 10;

		// 파일 업로드 및 Mutipart 객체 생성
		
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String group = mr.getParameter("group");
		
		String cate = mr.getParameter("cate");
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String oName = mr.getOriginalFileName("file");
		String regip = request.getRemoteAddr();
	
		logger.debug("Article write... cate : "+ cate);
		logger.debug("Article write... title : "+ title);
		logger.debug("Article write... writer : "+ writer);
		logger.debug("Article write... content : "+ content);
		logger.debug("Article write... file : "+ oName);
		
		// ArticleDTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setCate(cate);
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setFile(oName == null ? 0 : 1);
		dto.setRegip(regip);
		
		// 글 Insert
		int no = service.insertArticle(dto);
		
		if(oName != null) {
			
			int i = oName.lastIndexOf(".");
			String ext = oName.substring(i);
			
			String uuid = UUID.randomUUID().toString();
			String sName = uuid + ext;
				
			File f1 = new File(path+"/"+oName);
			File f2 = new File(path+"/"+sName);
			
			f1.renameTo(f2);
			
			FileDTO fileDto = new FileDTO();
			fileDto.setAno(no);
			fileDto.setOriName(oName);
			fileDto.setNewName(sName);
			
			fService.insertFile(fileDto);
			
		}
		
		
		// 서비스 호출 
		
		response.sendRedirect("/Farmstory2/board/list.do?group="+group+"&cate="+cate);
		
		
	}

}
