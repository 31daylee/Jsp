package kr.farmstory1.dao;

import java.util.ArrayList;
import java.util.List;

import kr.farmstory1.db.DBHelper;
import kr.farmstory1.db.SQL;
import kr.farmstory1.dto.ArticleDTO;

public class ArticleDAO extends DBHelper {
	
	
	//////////////////INSERT/////////////////////
	// 글쓰기
	public void insertArticle(ArticleDTO dto) {
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	// 댓글 쓰기
	public int insertComment(ArticleDTO dto) {
		
		int result = 0;
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			result = psmt.executeUpdate();
			
			close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/////////////////SELECT/////////////////////
	// 게시물 글목록에 나타내기
	public List<ArticleDTO> selectArticles(String cate, int start) {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
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
				
				articles.add(dto);
			}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return articles;
	}
	
	// 댓글 목록 보기 하기 !!! 
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
	
	// 글보기 
	public ArticleDTO selectArticle(String no) {
		
		ArticleDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ArticleDTO();
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
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// 게시물 전체 수 조회
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	// 메인 홈페이지(index)에서 최신순으로 글보기
	public List<ArticleDTO> selectLatests(String cate, int size) {
		List<ArticleDTO> latests = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_LATESTS);
			psmt.setString(1, cate);
			psmt.setInt(2, size);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setRdate(rs.getString(3));
				latests.add(dto);
			}
			
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return latests;
	}

	
	
	
	////////////////UPDATE//////////////////////
	// 글 수정 
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
			e.printStackTrace();
		}
		
	
	}
	public void updateComment(String no, String content) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, no);
			psmt.executeUpdate();
			
			close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 댓글 개수 업데이트 (Hit)
	public void updateArticleForCommentPlus(String no) {
		
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
	
	
	//////////////DELETE///////////////////////
	public void deleteArticle(String no) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public int deleteComment(String no) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.setString(1, no);
			result = psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
