package com.service;

import com.dao.CampDAO;
import com.dto.CampDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CampServiceImpl implements CampService {
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
    public List<CampDTO> findByName(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CampDTO> list = null;
        try {
            CampDAO dao = new CampDAO();
            list = dao.findByName(session, name);
        } finally {
            session.close();
        }

        return list;
    } //findByName end

    @Override
    public List<CampDTO> findByRecommendation(CampDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CampDTO> list = null;
        try{
            CampDAO dao = new CampDAO();
            list = dao.findByRecommendation(session, dto);
        }finally {
            session.close();
        }
        return list;
    } //findByRecommendation end

    @Override
    public List<CampDTO> printNameList(ArrayList<Integer> CIDs) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CampDTO> list = null;
        try{
            CampDAO dao = new CampDAO();
            list = dao.printNameList(session,CIDs);
        }finally {
            session.close();
        }
        return list;
    }//printNameList end

    @Override
    public List<CampDTO> printDetailByCID(int CID) {
        SqlSession session = sqlSessionFactory.openSession();
        List<CampDTO> list = null;
        try{
            CampDAO dao = new CampDAO();
            list = dao.printDetailByCID(session, CID);
        }finally {
            session.close();
        }
        return list;
    }//printDetailByCID end


}
