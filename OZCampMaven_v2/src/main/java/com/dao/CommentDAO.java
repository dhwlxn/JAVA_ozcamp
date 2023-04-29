package com.dao;

import com.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentDAO {

    public List<CommentDTO> findAll(SqlSession session, CommentDTO dto){
        List<CommentDTO> list = session.selectList("com.mybatis.CommentMapper.findAll",dto);
        return list;
    }


    public int insert(SqlSession session, CommentDTO dto) {
        int n = session.insert("com.mybatis.CommentMapper.insert", dto);
        return n;
    }


    public int update(SqlSession session, CommentDTO dto) {
        int n = session.update("com.mybatis.CommentMapper.update", dto);
        return n;
    }


    public int delete(SqlSession session, CommentDTO dto) {
        int n = session.delete("com.mybatis.CommentMapper.delete", dto);
        return n;
    }
}
