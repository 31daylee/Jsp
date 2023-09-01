package kr.co.Jboard2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Jboard2.dao.ArticleDAO;
import kr.co.Jboard2.dto.ArticleDTO;
import kr.co.Jboard2.dto.FileDTO;

public enum ArticleService {
	
	INSTANCE;
	
	
	ArticleDAO dao = new ArticleDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleDTO dto) {
		
		return dao.insertArticle(dto);
		
	}
	public ArticleDTO selectArticle(String no) {
		return dao.selectArticle(no);
	
	}
	public List<ArticleDTO> selectArticles(int start, String search) {
		return dao.selectArticles(start, search);
	
	}
	public void updateArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	
	}
	public void deleteArticle(String no) {
		dao.deleteArticle(no);
	
	}
	
	
	// 추가
	public int selectCountTotal(String search) {
		return dao.selectCountTotal(search);
	}
	
	public int insertComment(ArticleDTO dto) {
		return dao.insertComment(dto);
	}
	
	public List<ArticleDTO> selectComments(String parent) {
		return dao.selectComments(parent);
	}
	
	public void updateArticleForComment(String no) {
		dao.updateArticleForComment(no);
	}
	
	public void updateArticleForCommentMinus(String no) {
		dao.updateArticleForCommentMinus(no);
	}
	
	public int deleteComment(String no) {
		return dao.deleteComment(no);
	}
	
	
	
	// 업로드 경로 구하기
	public String getFilePath(HttpServletRequest request) {
		// 파일 업로드 경로 구하기
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/upload");
		return path;
	}
	
	// 파일명 수정
	public String renameToFile(HttpServletRequest request, String oName) {

		String path = getFilePath(request);
		
		int i = oName.lastIndexOf(".");
		String ext = oName.substring(i);
		
		String uuid = UUID.randomUUID().toString();
		String sName = uuid+ext;
		
		File f1 = new File(path+"/"+oName);
		File f2 = new File(path+"/"+sName);
		
		// 파일명 수정
		f1.renameTo(f2);
		return sName;
	}
	
	
	// 파일 업로드
	public MultipartRequest uploadFile(HttpServletRequest request) {
		//파일 경로 구하기
		String path = getFilePath(request);
		
		// 최대 업로드 파일 크기
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mr = null;
		// 파일 업로드
		
		
		try {
			mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
		}catch(IOException e) {
			logger.error("uploadFile : "+ e.getMessage());
		}
		
	
		return mr;
	}
	
	
	
	
	// 파일 다운로드
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, FileDTO fileDto) throws IOException {
		// response 파일 다운로드 헤더 수정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDto.getOfile(), "utf-8"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "private");
		
		// response 파일 스트림 작업
		String path = getFilePath(request);
		File file = new File(path+"/"+fileDto.getSfile());
		
		
		// 파일 처리하는 스트림 과정
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); // 파일 데이터를 fileDownload.jsp와 연결함
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); // 출력스트림은 response 객체와 연결. response는 클라이언트에게 전송됨
		
		// 파일 유무를 따지는 과정 
		while(true){
			
			int data = bis.read();
			if(data == -1){
				break;
			}
			
			bos.write(data);
		}
		bos.close();
		bis.close();
		
	}
	
}
