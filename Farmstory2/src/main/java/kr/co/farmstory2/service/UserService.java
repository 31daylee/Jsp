package kr.co.farmstory2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.UserDAO;
import kr.co.farmstory2.dto.UserDTO;

public enum	UserService {
	
	INSTANCE;
	
	UserDAO dao = new UserDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO dto) {
		dao.insertUser(dto);
	}
	
	public UserDTO selectUser(String uid, String pass) {
		return dao.selectUser(uid,pass);
	}
	public List<UserDTO> selectUsers() {
		
		return dao.selectUsers();
	}
	public void updateUser(UserDTO dto) {
		dao.updateUser(dto);
	}
	
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
	
	// 추가
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	}
	
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	
	public int selectCountNameAndEmail(String name, String email) {
		return dao.selectCountNameAndEmail(name, email);				
	}
	public int selectCountUidAndEmail(String uid, String email) {
		return dao.selectCountUidAndEmail(uid, email);	
	}
}
