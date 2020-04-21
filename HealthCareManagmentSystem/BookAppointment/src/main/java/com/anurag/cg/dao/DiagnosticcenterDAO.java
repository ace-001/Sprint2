package com.anurag.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.cg.dto.Diagnosticcenter;


@Repository
public interface DiagnosticcenterDAO extends JpaRepository<Diagnosticcenter,Integer> 
{
	
}
