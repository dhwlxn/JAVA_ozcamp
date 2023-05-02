package com.dao;

import com.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentDAO {

    public int maxvalue(SqlSession session) {
        int n = session.selectOne("com.mybatis.CommentMapper.maxvalue");
        return n;
    }

    public List<CommentDTO> findAll(SqlSession session, int CUID){
        List<CommentDTO> list = session.selectList("com.mybatis.CommentMapper.findAll",CUID);
        return list;
    }

    public List<CommentDTO> findByCamp(SqlSession session, int CID){
        List<CommentDTO> list = session.selectList("com.mybatis.CommentMapper.findByCamp",CID);
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
