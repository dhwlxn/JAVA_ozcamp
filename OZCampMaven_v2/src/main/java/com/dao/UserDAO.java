package com.dao;

import com.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAO {
    public int maxvalue(SqlSession session) {
        int n = session.selectOne("com.mybatis.UserMapper.maxvalue");
        return n;
    }
    public int register(SqlSession session, UserDTO dto){
        int n = session.insert("com.mybatis.UserMapper.register", dto);
        return n;
    }

    public int isIdDuplicated(SqlSession session, String ID) {
        int n = session.selectOne("com.mybatis.UserMapper.isidduplicated", ID);
        return n;
    }

    public String logIn (SqlSession session, UserDTO dto){
        String PW = session.selectOne("com.mybatis.UserMapper.logIn",dto);
        return PW;
    }

    public List<UserDTO> findAll(SqlSession session){
        List<UserDTO> dto = session.selectList("com.mybatis.UserMapper.findAll");
        return dto;
    }

    public int getCUID(SqlSession session, UserDTO dto) {
        int CUID = session.selectOne("com.mybatis.UserMapper.getcuid", dto);
        return CUID;
    }

    public int delete(SqlSession session, int CUID){
        int n = session.delete("com.mybatis.UserMapper.delete", CUID);
        return n;
    }


}
