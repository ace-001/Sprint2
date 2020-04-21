package com.anurag.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.cg.dto.Test;

@Repository
	public interface TestDAO extends JpaRepository<Test,Integer> 
	{
		
	}


