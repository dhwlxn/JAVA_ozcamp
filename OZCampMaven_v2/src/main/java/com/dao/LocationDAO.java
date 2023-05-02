package com.dao;

import com.dto.LocationDTO;
import org.apache.ibatis.session.SqlSession;

public class LocationDAO {

    public LocationDTO findByDistrict(SqlSession session, LocationDTO dto){
        LocationDTO location = session.selectOne("com.mybatis.LocationMapper.findByDistrict", dto);
        return location;
    }
}
