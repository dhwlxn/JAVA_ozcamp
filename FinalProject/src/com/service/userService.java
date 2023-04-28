package com.service;

import java.util.List;
import com.dto.UserDTO;

import com.Exception.DuplicatedUsernoException;
import com.Exception.RecordNotFoundException;

public interface userService {

	public abstract List<UserDTO> findAll();
	
	//insert
	public int insert(UserDTO dto) throws DuplicatedUsernoException;
	
	//update
	public int update(UserDTO dto) throws RecordNotFoundException;
	
	//delete
	public int delete(String ID, String PW) 
			//throws RecordNotFoundException
			;

	
}