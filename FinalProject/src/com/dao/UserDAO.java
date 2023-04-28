package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.UserDTO;


public class UserDAO {
	//회원가입에 대한 사항
	public int insert(SqlSession session,UserDTO dto) {
		int n = session.insert("insert", dto);
		return n;
	}
	
	
	
	//관리자 계정 시 회원 관리 명목하 논의
	public List<UserDTO> findAll(SqlSession session) {
		
		List<UserDTO> list = session.selectList("findAll");
		return list;
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