package com.dao;

import com.dto.UserDTO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDAO {
    public int register(SqlSession session, UserDTO dto){
        int n = session.insert("com.mybatis.UserMapper.register", dto);
        return n;
    }

    public String logIn (SqlSession session, UserDTO dto){
        String PW = session.selectOne("com.mybatis.UserMapper.logIn",dto);
        return PW;
    }

    public int delete(SqlSession session, int CUID){
        int n = session.delete("com.mybatis.UserMapper.delete", CUID);
        return n;
    }
    
    public List<UserDTO> findAll(SqlSession session){
    	List<UserDTO> dto = session.selectList("com.mybatis.UserMapper.findAll");
    	return dto;
    }

    public int getCUID(SqlSession session, UserDTO dto) {
    	int CUID = session.selectOne("com.mybatis.UserMapper.getcuid", dto);
    	return CUID;
    }
    
}
