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
	
	
	public void insertArticle(ArticleDTO dto) {}
	
	public ArticleDTO selectArticle(String no) {
		return null;
	}
	public List<ArticleDTO> selectArticles() {
		
		return null;
	}
	public void updateArticle(ArticleDTO dto) {}
	
	public void deleteArticle(String no) {}
}
