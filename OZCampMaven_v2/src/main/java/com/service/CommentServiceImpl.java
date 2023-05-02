package com.service;

import com.dao.CampDAO;
import com.dao.CommentDAO;
import com.dto.CommentDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService{

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

    /* 기본틀
            SqlSession session = sqlSessionFactory.openSession();
        try{

        }finally {
            session.close();
        }
     */


    @Override
    public int maxvalue() {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            CommentDAO dao = new CommentDAO();
            n = dao.maxvalue(session);
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public List<CommentDTO> findAll(int CUID) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CommentDTO> list = null;
        try{
            CommentDAO dao = new CommentDAO();
            list = dao.findAll(session, CUID);
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<CommentDTO> findByCamp(int CID) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CommentDTO> list = null;
        try{
            CommentDAO dao = new CommentDAO();
            list = dao.findByCamp(session, CID);
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public int insert(CommentDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            CommentDAO dao = new CommentDAO();
            n = dao.insert(session,dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public int update(CommentDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            CommentDAO dao = new CommentDAO();
            n = dao.update(session,dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }

    @Override
    public int delete(CommentDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        int n = 0;
        try{
            CommentDAO dao = new CommentDAO();
            n = dao.delete(session,dto);
            session.commit();
        }finally {
            session.close();
        }
        return n;
    }
}
