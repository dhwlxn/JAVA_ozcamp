package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.CampDTO;

public class CampDAO {
	public List<CampDTO> findAll(SqlSession session) {
		List<CampDTO> list = session.selectList("findAll");
		//우선 findALL로 해두었으나, 각 조건에 맞는 캠핑장 리스트 가지고오는 것으로 수정하여야 함
		return list;
	}
	
//////////////////////////////////////////////////////////	
//하단에 관리자 권한에 대한 사항 넣을지 여부 체크하여 아래 메뉴 추가 고려ㄴ
	public int insert(SqlSession session,CampDTO dto) {
		int n = session.insert("insert", dto);
		return n;
	}
	
	public int update(SqlSession session,CampDTO dto) {
		int n = session.insert("update", dto);
		return n;
	}
	
	public int delete(SqlSession session,int CID) {
		int n = session.insert("delete", CID);
		return n;
	}
	
	
}