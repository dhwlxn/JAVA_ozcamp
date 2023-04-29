package com.dao;

import com.dto.CampDTO;
import com.dto.WishlistDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WishlistDAO {
    public int insert(SqlSession session, WishlistDTO dto){
        int n = session.insert("com.mybatis.WishlistMapper.insert", dto);
        return n;
    }

    public int delete(SqlSession session, WishlistDTO dto){
        int n = session.delete("com.mybatis.WishlistMapper.delete", dto);
        return n;

    }

    public List<WishlistDTO> findAll(SqlSession session, int UID){
        List<WishlistDTO> list = session.selectList("com.mybatis.WishlistMapper.findAll", UID);
        return list;
    }

}
