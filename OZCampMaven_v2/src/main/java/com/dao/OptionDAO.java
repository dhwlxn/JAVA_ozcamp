package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CampDTO;
import com.dto.OptionDTO;


// 최대 최소 위도경도 담는 DTO
public class OptionDAO {
    public List<CampDTO> findByOption (SqlSession session, OptionDTO dto){
        List<CampDTO> list = session.selectList("com.mybatis.LocationMapper.findByOption", dto);
        return list;
    }

}
