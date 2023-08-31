package kr.co.Jboard2.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Jboard2.db.DBHelper;
import kr.co.Jboard2.db.SQL;
import kr.co.Jboard2.dto.ArticleDTO;

public class ArticleDAO extends DBHelper{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public int insertArticle(ArticleDTO dto) {
		
		logger.debug("ArticleDAO insertArticle ...1");

		int no = 0;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // Transaction 시작
			
			stmt = conn.createStatement(); 
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			conn.commit(); //작업확정
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO insert error :  "+e.getMessage());
		}
		return no;
	}
	
	
	public ArticleDTO selectArticle(String no) {
		ArticleDTO dto = new ArticleDTO();;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				dto.setNo(rs.getInt("no"));
				dto.setParent(rs.getInt("parent"));
				dto.setComment(rs.getInt("comment"));
				dto.setCate(rs.getString("cate"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFile(rs.getInt("file"));
				dto.setHit(rs.getInt("hit"));
				dto.setWriter(rs.getString("writer"));
				dto.setRegip(rs.getString("regip"));
				dto.setRdate(rs.getString("rdate"));
			
			}
			logger.debug("selectArticle dto..." +dto);
			close();
		}catch(Exception e ) {
			logger.error("ArticleDAO selectArticle error :  "+e.getMessage());
		}
		
		return dto;
	}
	

	
	public List<ArticleDTO> selectArticles(int start) {
		
		logger.debug("ArticleDAO selectArticles ...1");
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setCate(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setFile(rs.getInt(7));
				dto.setHit(rs.getInt(8));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdate(rs.getString(11));
				dto.setNick(rs.getString(12));
				
				articles.add(dto);
			}
			close();
			
			logger.debug("ArticleDAO selectArticles ...2");
			
			
		}catch(Exception e) {
			logger.error("ArticleDAO selectArticles error :  "+e.getMessage());
		}
		
		
		return articles;
	}
	
	
	
	
	public void updateArticle(ArticleDTO dto) {

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getNo());
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error("ArticleDAO updateArticle error :  "+e.getMessage());
		}
	}
	public void deleteArticle(String no) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO deleteArticle error :  "+e.getMessage());
		}
		
		
	}
	
	// 추가
	// 모든 아티클 원글만 조회
	public int selectCountTotal() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO selectCountTotal error :  "+e.getMessage());
		}
		return total;
	}
	
	// 댓글
	// 댓글 추가하기
	
	public int insertComment(ArticleDTO dto) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			result = psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 댓그 리스트에 출력
	public List<ArticleDTO> selectComments(String parent) {
		
		List<ArticleDTO> comments = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setString(1, parent);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setCate(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setFile(rs.getInt(7));
				dto.setHit(rs.getInt(8));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdate(rs.getString(11));
				dto.setNick(rs.getString(12));
				
				comments.add(dto);
			}
			
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	
	
	public void updateArticleForComment(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_FOR_COMMENT_PLUS);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticleForCommentMinus(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ARTICLE_FOR_COMMENT_MINUS);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
