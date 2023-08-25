package service;

import java.util.List;

import dao.User2DAO;
import dto.User2DTO;

public enum User2Service {
	
	INSTANCE;
	private User2DAO dao = User2DAO.INSTANCE;
	
	
	public void insertUser2(User2DTO dto) {
		dao.insertUser2(dto);
	}
	
	public User2DTO selectUser2(String uid) {
		return dao.selectUser2(uid);
	}
	
	public List<User2DTO> selectUser2s() {
		return dao.selectUser2s();
	}
	
	public void updateUser2(User2DTO dto) {
		dao.updateUser2(dto);
	}
	
	public void deleteUser2(String uid) {
		dao.deleteUser2(uid);
	}
	
	
	
	
}
