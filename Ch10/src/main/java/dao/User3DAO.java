package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DBHelper;
import dto.User3DTO;


public class User3DAO extends DBHelper{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertUser3(User3DTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT `user3` VALUES (?,?,?,?)");
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			
			close();
			
			
		}catch(Exception e) {
			logger.error("User3 insertUser3 ... errro : "+e.getMessage());
		}
		
		
	}
	public User3DTO selectUser3(String uid) {
	
		User3DTO dto = new User3DTO();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user3` WHERE `uid`=?");
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
			}
			close();
			
		}catch(Exception e) {
			logger.error("User3 selectUser3 ... error : "+e.getMessage());
		}
		
		
		return dto;
	}
	public List<User3DTO> selectUser3s() {
		
		List<User3DTO> users = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user3`");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				users.add(dto);
			}
			close();
			
		}catch(Exception e) {
			logger.error("User3 selectUser3s ... errro : "+e.getMessage());
		}
		
		return users;
	}
	
	
	
	public void updateUser3(User3DTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `user3` SET `name`=?, `hp`=?, `age`=? WHERE `uid`=?");
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUid());
			
			psmt.executeUpdate();
			
			close();
			close();
			
			
		}catch(Exception e) {
			logger.error("User3 deleteUser3 ... errro : "+e.getMessage());
		}
	}
	
	
	public void deleteUser3(String uid) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `user3` WHERE `uid`=?");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			
			close();
			
			
		}catch(Exception e) {
			logger.error("User3 deleteUser3 ... errro : "+e.getMessage());
		}
		
		
	}
	
	
	
}
