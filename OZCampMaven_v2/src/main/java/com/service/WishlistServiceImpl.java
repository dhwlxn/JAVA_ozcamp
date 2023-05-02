package com.service;

import com.dao.WishlistDAO;
import com.dto.WishlistDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WishlistServiceImpl implements WishlistService{

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
    public int insert(WishlistDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            WishlistDAO dao = new WishlistDAO();
            dao.insert(session, dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public int delete(WishlistDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n ;
        try{
            WishlistDAO dao = new WishlistDAO();
            n=dao.delete(session, dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public int deleteAll(int CUID) {
        SqlSession session = sqlSessionFactory.openSession();
        int n ;
        try{
            WishlistDAO dao = new WishlistDAO();
            n=dao.deleteAll(session, CUID);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }


    @Override
    public List<WishlistDTO> findAll(int CUID) {
        SqlSession session = sqlSessionFactory.openSession();
        List<WishlistDTO> list = null;
        try{
            WishlistDAO dao = new WishlistDAO();
            list = dao.findAll(session, CUID);
        }finally {
            session.close();
        }
        return list;
    }

}
