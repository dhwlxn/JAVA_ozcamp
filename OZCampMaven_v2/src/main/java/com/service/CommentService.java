package com.service;

import com.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    int maxvalue();

    List<CommentDTO> findAll(int CUID);

    List<CommentDTO> findByCamp(int CID);

    int insert(CommentDTO dto);

    int update(CommentDTO dto);

    int delete(CommentDTO dto);
}
