package kr.co.jboard1.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.db.DBHelper;
import kr.co.jboard1.db.SQL;
import kr.co.jboard1.vo.ArticleVO;

public class ArticleDAO extends DBHelper {
	
	
	public void insertArticle(ArticleVO vo) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getRegip());
			psmt.executeUpdate();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArticleVO selectArticle(int no) {
		return null;
	}
	
	public List<ArticleVO> selectArticles(int start) {
		
		List<ArticleVO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				ArticleVO list = new ArticleVO();
				list.setNo(rs.getInt(1));
				list.setParent(rs.getInt(2));
				list.setComment(rs.getInt(3));
				list.setCate(rs.getString(4));
				list.setTitle(rs.getString(5));
				list.setContent(rs.getString(6));
				list.setFile(rs.getInt(7));
				list.setHit(rs.getInt(8));
				list.setWriter(rs.getString(9));
				list.setRegip(rs.getString(10));
				list.setRdate(rs.getString(11));
				list.setNick(rs.getString(12));
				
				articles.add(list);
			}
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	
	
	public void updateArticle(ArticleVO vo) {}
	public void deleteArticle(int no) {}
	
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
			e.printStackTrace();
		}
		return total;
	}
}
