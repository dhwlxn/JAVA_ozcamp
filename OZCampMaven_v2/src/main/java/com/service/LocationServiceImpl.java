package com.service;

import com.dao.LocationDAO;

import com.dao.OptionDAO;
import com.dto.CampDTO;
import com.dto.LocationDTO;
import com.dto.OptionDTO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LocationServiceImpl implements LocationService{
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
    public LocationDTO findByDistrict(LocationDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();
        LocationDTO location = new LocationDTO();
        try{
            LocationDAO dao = new LocationDAO();
            location = dao.findByDistrict(session, dto);
        }finally {
            session.close();
        }
        return location;
    }

    
	@Override
	public List<CampDTO> findByOption(OptionDTO dto) {
		SqlSession session = sqlSessionFactory.openSession();
        List<CampDTO> list =  null;
        try{
        	OptionDAO dao = new OptionDAO();
            list = dao.findByOption(session, dto);
        }finally {
            session.close();
        }
        return list;
	}
}
