package com.anurag.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anurag.cg.dao.DiagnosticcenterDAO;
import com.anurag.cg.dto.Diagnosticcenter;
@Service
public class DiagnosticcenterService {
	@Autowired
    DiagnosticcenterDAO ddao;
    public void setDcdao( DiagnosticcenterDAO ddao) 
    { 
    	this.ddao=ddao;
    	} 
	
	@Transactional(readOnly=true)
    public List<Diagnosticcenter> getDiagnosticcenters()
    {
    	return ddao.findAll();
    }
}
