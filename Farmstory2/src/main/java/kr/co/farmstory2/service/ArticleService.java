package kr.co.farmstory2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.ArticleDAO;
import kr.co.farmstory2.dto.ArticleDTO;

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
	public List<ArticleDTO> selectArticles(int start ,String cate) {
		
		return dao.selectArticles(start, cate);
	}
	public void updateArticle(ArticleDTO dto) {
		dao.updateArticle(dto);
	}
	
	public void deleteArticle(String no) {
		dao.deleteArticle(no);
	}
	
	
	// 추가
	
	// 카테고리 별 모든 원글 조회
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
		
	}
	
	
	// 파일 다운로드

	
	
	// 댓글 입력
	public int insertComment(ArticleDTO dto) {
		return dao.insertComment(dto);
	}
	
	// 댓글 목록 리스트 조회
	public List<ArticleDTO> selectComments(String parnet) {
		return dao.selectComments(parnet);
	}
	// 댓글 삭제
	public int deleteComment(String no) {
		return dao.deleteComment(no);
	}
	// 댓글 수정
	public int updateComment(String no, String content) {
		return dao.updateComment(no, content);
	}
	
}
