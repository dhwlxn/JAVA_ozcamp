package com.service;

import com.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findall(CommentDTO dto);

    int insert(CommentDTO dto);

    int update(CommentDTO dto);

    int delete(CommentDTO dto);
}
