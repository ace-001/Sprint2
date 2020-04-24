package com.cg.hcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.dao.DiagnosticcenterDAO;
import com.cg.hcs.dto.Diagnosticcenter;

@Service
public class DiagnosticcenterService 
{	
	@Autowired
    DiagnosticcenterDAO ddao;
    public void setDdao( DiagnosticcenterDAO ddao) { this.ddao=ddao;}
    @Transactional
    public Diagnosticcenter insertDiagnosticcenter( Diagnosticcenter  diagnosticcenter)
    {
        return ddao.save( diagnosticcenter);
    }
	
    @Transactional
    public String deleteDiagnosticcenter(int centerId)
    {
    	ddao.deleteById(centerId);
    	return "center Deleted";
    }
    @Transactional(readOnly=true)
    public List<Diagnosticcenter> getDiagnosticcenters()
    {
    	return ddao.findAll();
    }
    @Transactional(readOnly=true)
    public Optional<Diagnosticcenter> getDiagnosticcenter(int centerId)
    {
    	return ddao.findById(centerId);
    }
    
}
