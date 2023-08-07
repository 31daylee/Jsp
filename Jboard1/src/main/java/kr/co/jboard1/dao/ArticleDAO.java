package kr.co.jboard1.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.db.DBHelper;
import kr.co.jboard1.db.SQL;
import kr.co.jboard1.vo.ArticleVO;

public class ArticleDAO extends DBHelper {
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	
	private ArticleDAO() {}
	
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
	public List<ArticleVO> selectArticles() {
		
		List<ArticleVO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ARTICLES);
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
	
	
}
