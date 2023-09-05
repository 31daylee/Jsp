package kr.co.farmstory2.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.db.DBHelper;
import kr.co.farmstory2.db.SQL;
import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;

public class ArticleDAO extends DBHelper{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleDTO dto) {
		
		int no = 0;
		
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFile());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			
			rs = stmt.executeQuery(SQL.SELECT_MAX_NO);
			conn.commit();
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO insertArticle error... : "+ e.getMessage());
		}
		
		return no;
		
	}
	
	public ArticleDTO selectArticle(String no) {
		
		ArticleDTO dto = new ArticleDTO();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
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
				
				FileDTO fileDto = new FileDTO();
				fileDto.setFno(rs.getInt(12));
				fileDto.setAno(rs.getInt(13));
				fileDto.setOriName(rs.getString(14));
				fileDto.setNewName(rs.getString(15));
				fileDto.setDownload(rs.getInt(16));
				fileDto.setRdate(rs.getString(17));
				
				dto.setFileDto(fileDto);
			}
			
			logger.debug("selectArticle dto..." +dto);
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO selectArticle error... : "+ e.getMessage());
		}
		
		
		return dto;
	}
	
	
	
	public List<ArticleDTO> selectArticles(int start,String cate) {
		
		List<ArticleDTO> articles = new ArrayList<ArticleDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
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
				dto.setCommentCount(rs.getString(13));
				
				
				articles.add(dto);
			}
			
			logger.debug("selectArticles rs.. "+ rs);
			close();
			
			
		}catch(Exception e) {
			logger.error("ArticleDAO selectArticles error... : "+ e.getMessage());
		}
		
		
		
		return articles;
	}
	
	
	
	
	public void updateArticle(ArticleDTO dto) {}
	
	public void deleteArticle(String no) {}
	
	
	// 추가
	public int selectCountTotal(String cate) {
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO selectCountTotal error... : "+ e.getMessage());
		}
		
		return total;
		
	}
	
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
			logger.error("ArticleDAO insertComment error... : "+ e.getMessage());
		}
		return result;
	}
	
	// 댓글 조회하기
	public List<ArticleDTO> selectComments(String parnet) {
		
		List<ArticleDTO> comments = new ArrayList<>();
		
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENTS);
			psmt.setString(1, parnet);
			
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
			logger.error("ArticleDAO selectComments error... : "+ e.getMessage());
		}
		
		return comments;
	}
	
	public int deleteComment(String no) {
		
		int result =0 ;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			result = psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error("ArticleDAO deleteComment error :  "+e.getMessage());
		}
		
		return result;
	}
	
	
	
	
}
