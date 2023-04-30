package com.service;

import com.dao.CampDAO;
import com.dao.UserDAO;
import com.dao.WishlistDAO;
import com.dto.UserDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    public String logIn(UserDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        String PW = null;
        try{
            UserDAO dao = new UserDAO();
             PW = dao.logIn(session, dto);
        }finally {
            session.close();
        }
        return PW;
    }

    @Override
    public int delete(int CUID) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            UserDAO dao = new UserDAO();
            n = dao.delete(session, CUID);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

	@Override
	public List<UserDTO> findAll() {

		SqlSession session = sqlSessionFactory.openSession();
        List<UserDTO> dto = null;
        try{
            UserDAO dao = new UserDAO();
            dto = dao.findAll(session);
        }finally {
            session.close();
        }
				
		
		return dto;
	}

	@Override
	public int getCUID(UserDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int CUID;
        try{
            UserDAO dao = new UserDAO();
             CUID = dao.getCUID(session, dto);
        }finally {
            session.close();
        }
        return CUID;
	
	}


}
