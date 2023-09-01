package kr.co.Jboard2.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Jboard2.dto.FileDTO;
import kr.co.Jboard2.service.ArticleService;
import kr.co.Jboard2.service.FileService;


@WebServlet("/fileDownload.do")
public class fileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService aService = ArticleService.INSTANCE;
	private FileService fService = FileService.INSTANCE; 
	
    public fileDownloadController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 수신
		String fno = request.getParameter("fno");
		logger.debug("fno : "+fno);
		
		
		// 파일 조회
		FileDTO fileDto = fService.selectFile(fno);
		logger.debug(fileDto.toString());
		
		// 파일 다운로드_ArticleService에서 호출-> 관련 내용은 아래 참고
		aService.downloadFile(request, response, fileDto);
		
	}



}
