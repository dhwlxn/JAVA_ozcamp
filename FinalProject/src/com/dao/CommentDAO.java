package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.CommentDTO;


public class CommentDAO {
	//댓글 입력에 대한 사항
	public int insert(SqlSession session,CommentDTO dto) {
		int n = session.insert("insert", dto);
		return n;
	}
	//마이페이지 내 내가 쓴 댓글 확인하여 출력 
	public List<CommentDTO> findAll(SqlSession session) {
		List<CommentDTO> list = session.selectList("findAll");
		return list;
	}
	//마이페이지 내 내가 쓴 댓글 확인하여 수정
	public int update(SqlSession session,CommentDTO dto) {
		int n = session.insert("update", dto);
		return n;
	}
	//마이페이지 내 내가 쓴 댓글 확인하여 삭제
	public int delete(SqlSession session,String ID) {
		int n = session.insert("delete", ID);
		return n;
	}
	
	
}