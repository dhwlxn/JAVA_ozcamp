package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.UserDTO;


public class LocationDAO {
	//입력한 동 가져올 때
	public List<UserDTO> findAll(SqlSession session) {
		
		List<UserDTO> list = session.selectList("findAll");
		return list;
	}
	
	
	
	
	//주소 관리 파트
	public int insert(SqlSession session,UserDTO dto) {
		int n = session.insert("insert", dto);
		return n;
	}
	public int update(SqlSession session,UserDTO dto) {
		int n = session.insert("update", dto);
		return n;
	}
	public int delete(SqlSession session,String ID) {
		int n = session.insert("delete", ID);
		return n;
	}
}