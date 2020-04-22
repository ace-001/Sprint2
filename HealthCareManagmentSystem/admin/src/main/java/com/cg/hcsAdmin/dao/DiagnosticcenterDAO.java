package com.cg.hcsAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hcsAdmin.dto.Diagnosticcenter;

@Repository
public interface DiagnosticcenterDAO extends JpaRepository<Diagnosticcenter, Integer> 
{

}
