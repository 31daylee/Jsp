package kr.co.Jboard2.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Jboard2.dao.ArticleDAO;
import kr.co.Jboard2.dto.ArticleDTO;

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
	public List<ArticleDTO> selectArticles(int start) {
		return dao.selectArticles(start);
	
	}
	public void updateArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	
	}
	public void deleteArticle(String no) {
		dao.deleteArticle(no);
	
	}
	
	
	// 추가
	public int selectCountTotal() {
		return dao.selectCountTotal();
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
	public void downloadFile() {
		
	}
	
}
