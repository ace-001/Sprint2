package com.cg.hcsAdmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.hcsAdmin.dao.DiagnosticcenterDAO;
import com.cg.hcsAdmin.dao.TestDAO;
import com.cg.hcsAdmin.dto.Diagnosticcenter;

@Service
public class DiagnosticcenterService 
{	
	@Autowired
    DiagnosticcenterDAO ddao;
	@Autowired
	TestDAO tdao;
    public void setDdao( DiagnosticcenterDAO ddao) { this.ddao=ddao;}
    public void setTdao( TestDAO tdao) { this.tdao=tdao;}
    @Transactional
    public Diagnosticcenter insertDiagnosticcenter( Diagnosticcenter  diagnosticcenter)
    {
        return ddao.save( diagnosticcenter);
    }
	
    @Transactional
    public String deleteDiagnosticcenter(int centerId)
    {
    	tdao.deleteAll();
    	ddao.deleteById(centerId);
    	return "center Deleted";
    }
    
}