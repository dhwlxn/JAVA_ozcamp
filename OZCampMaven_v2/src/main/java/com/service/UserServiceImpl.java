package com.service;

import com.dao.CampDAO;
import com.dao.UserDAO;
import com.dto.UserDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl implements UserService{

    //Session 얻기
    static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "com/mybatis/Configuration.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } // Session 얻는 static 블럭 end

    /*
    SqlSession session = sqlSessionFactory.openSession();
    try{

    }finally {
        session.close();
    }
 */
    @Override
    public int register(UserDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            UserDAO dao = new UserDAO();
            n = dao.register(session, dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public int logIn(UserDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int UID = 0;
        try{
            UserDAO dao = new UserDAO();
            UID = dao.logIn(session, dto);
        }finally {
            session.close();
        }
        return UID;
    }

    @Override
    public int delete(int UID) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            UserDAO dao = new UserDAO();
            n = dao.delete(session, UID);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }


}
