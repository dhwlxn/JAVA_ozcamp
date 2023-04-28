package com.service;

import java.util.List;
import com.dto.CampDTO;

import com.Exception.DuplicatedCampnoException;
import com.Exception.RecordNotFoundException;

public interface campService {

	public abstract List<CampDTO> findAll();
	
	//insert
	public int insert(CampDTO dto) throws DuplicatedCampnoException;
	
	//update
	public int update(CampDTO dto) throws RecordNotFoundException;
	
	//delete
	public int delete(int campno) 
			//throws RecordNotFoundException
			;

	
}