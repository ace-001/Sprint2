package com.anurag.cg.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anurag.cg.dao.TestDAO;
import com.anurag.cg.dto.Test;
@Service
public class TestService {
	@Autowired
    TestDAO tdao;
    public void setTdao( TestDAO tdao) 
    { 
    	this.tdao=tdao;
    	} 
	
	@Transactional(readOnly=true)
    public List<Test> getTests()
    {
    	return tdao.findAll();
    }

}
