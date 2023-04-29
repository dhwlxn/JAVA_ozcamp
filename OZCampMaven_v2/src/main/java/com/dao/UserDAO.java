package com.dao;

import com.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

public class UserDAO {
    public int register(SqlSession session, UserDTO dto){
        int n = session.insert("com.mybatis.UserMapper.Register", dto);
        return n;
    }

    public int logIn (SqlSession session, UserDTO dto){
        int UID = session.selectOne("com.mybatis.UserMapper.logIn",dto);
        return UID;
    }

    public int delete(SqlSession session, int UID){
        int n = session.delete("com.mybatis.UserMapper.delete", UID);
        return n;
    }


}
