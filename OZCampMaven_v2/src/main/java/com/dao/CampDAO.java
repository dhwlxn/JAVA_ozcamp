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


    public CampDTO printDetailByCID(SqlSession session, int CID){
        CampDTO list = session.selectOne("com.mybatis.CampMapper.printDetailByCID", CID);
        return list;
    }


}
