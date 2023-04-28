package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Exception.DuplicatedUsernoException;
import com.Exception.RecordNotFoundException;
import com.dao.UserDAO;
import com.dto.UserDTO;


public class userServiceImpl implements userService {
	
	//Connection 역할의 SQLSession 얻기
	///무조건 실행하는 아이이기 때문에 static으로 선언하기////////////////////////////
	static SqlSessionFactory sqlSessionFactory;
	static {
	String resource = "com/mybatis/Configuration.xml";
	InputStream inputStream = null;
	try {
		inputStream = Resources.getResourceAsStream(resource);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sqlSessionFactory = 
	  new SqlSessionFactoryBuilder().build(inputStream);
	}
	/////////////////////////////////////////////////////////////////////
	
	@Override
	public List<UserDTO> findAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<UserDTO> list = null;
		try {
			UserDAO dao = new UserDAO();
			list = dao.findAll(session);
			session.commit();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	@Override
	public int insert(UserDTO dto) throws DuplicatedUsernoException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			UserDAO dao = new UserDAO();
			n = dao.insert(session, dto);
			// jdbc: autocommit,  mybatis: 명시적으로 commit 필요
			session.commit();
		} catch (Exception e) {
			throw new DuplicatedUsernoException(dto.getID()+"가 중복되었습니다.");
		} finally {
			// 역순으로 close() 작업을 수행
			if(session!=null)session.close();
		}
		return n;
	}
	
	@Override
	public int update(UserDTO dto) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			UserDAO dao = new UserDAO();
			n = dao.update(session, dto);
			// jdbc: autocommit,  mybatis: 명시적으로 commit 필요
			session.commit();
		} catch (Exception e) {
			throw new RecordNotFoundException(dto.getID()+"가 없습니다.");
		} finally {
			// 역순으로 close() 작업을 수행
			if(session!=null)session.close();
		}
		return n;
	}
	@Override
	public int delete(String ID, String PW) //throws RecordNotFoundException 
	{
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		//try {
			UserDAO dao = new UserDAO();
			n = dao.delete(session, ID);
			// jdbc: autocommit,  mybatis: 명시적으로 commit 필요
			session.commit();
		//} catch (Exception e) {
		//	throw new RecordNotFoundException("부서번호"+deptno+"가 없습니다.");
		//} finally {
			// 역순으로 close() 작업을 수행
			if(session!=null)session.close();
		//}
		return n;
	}
	
}