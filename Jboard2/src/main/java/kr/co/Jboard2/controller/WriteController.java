package kr.co.Jboard2.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
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

import kr.co.Jboard2.dto.ArticleDTO;
import kr.co.Jboard2.dto.FileDTO;
import kr.co.Jboard2.service.ArticleService;
import kr.co.Jboard2.service.FileService;

@WebServlet("/write.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// service 사용을 위한 호출
	private ArticleService aService = ArticleService.INSTANCE;
	private FileService fService = FileService.INSTANCE;
	
	// 로깅 기능 구현을 위한 Logger 인스턴스 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
    public WriteController() {

    }
    // 페이지 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/write.jsp");
		dispatcher.forward(request, response);
	}
	
	// POST 요청 처리 _ 클라이언트가 게시물 작성 폼을 제출하면 호출된다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 파일 업로드 요청 처리
		MultipartRequest mr = aService.uploadFile(request);
	
		// 폼 데이터 수신_ mr로 파라미터를 호출하는 것이 중요한 포인트
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String oName = mr.getOriginalFileName("file");
		String regip = request.getRemoteAddr();
		
		// 로깅을 통한 코드 흐름 분석 
		logger.debug("title : " + title);
		logger.debug("content : " + content);
		logger.debug("writer : " + writer);
		logger.debug("oName : " + oName);
		logger.debug("regip : " + regip);
		
		
		// DTO 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(oName == null ? 0 : 1);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		// 클라이언트가 글쓰기 할 시 DB에 insert 할 수 있게 한다
		int no = aService.insertArticle(dto);
		
		
		// 파일명 수정 및 파일 테이블 Insert
		if(oName != null) { //...업로드 된 파일이 존재하는 경우에만 실행된다. oName은 업로드 된 원본 파일 이름을 나타낸다.
			String sName = aService.renameToFile(request, oName); //...메서드를 호출하여 업로드된 파일을 이름을 수정한다. 이 때 파일명은 UUID를 통한 새로운 형식의 이름을 지니게 된다.
			
			// 파일 객체를 생성하고 파일 정보 담는다
			FileDTO fileDto = new FileDTO();
			fileDto.setAno(no);
			fileDto.setOfile(oName);
			fileDto.setSfile(sName);
			
			// DB의 파일 테이블에 파일 정보 삽입 
			fService.insertFile(fileDto);
		}
		logger.debug("WriteController doPost..2");
		
		// 모든 작업 완료 후 list.do로 리다이렉트 
		response.sendRedirect("/Jboard2/list.do");
	}
}
