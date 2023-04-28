package com.dao;

import com.dto.CampDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CampDAO {

    public List<CampDTO> findByName (SqlSession session, String name){
        List<CampDTO> list = session.selectList("com.mybatis.CampMapper.findByName",name);
        return list;
    }

    public List<CampDTO> findByRecommendation (SqlSession session, CampDTO dto){
        List<CampDTO> list = session.selectList("com.mybatis.CampMapper.findByRecommendation", dto);
        return list;
    }

    public List<CampDTO> printNameList(SqlSession session, ArrayList<Integer> CIDs){
        List<CampDTO> list = session.selectList("com.mybatis.CampMapper.printNameList", CIDs);
        return list;
    }

    public List<CampDTO> printDetailByCID(SqlSession session, int CID){
        List<CampDTO> list = session.selectList("com.mybatis.CampMapper.printDetailByCID", CID);
        return list;
    }


}
