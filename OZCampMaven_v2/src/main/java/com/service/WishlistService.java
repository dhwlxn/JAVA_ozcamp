package com.service;

import com.dto.WishlistDTO;

import java.util.List;

public interface WishlistService {
    int insert (WishlistDTO dto);

    int delete (WishlistDTO dto);

    List<WishlistDTO> findAll(int CUID);
    
    int deleteAll(int CUID);
}
