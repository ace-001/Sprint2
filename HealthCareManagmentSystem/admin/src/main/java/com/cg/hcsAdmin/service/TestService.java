package com.cg.hcsAdmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcsAdmin.dao.TestDAO;
import com.cg.hcsAdmin.dto.Test;

@Service
public class TestService 
{
	@Autowired
	TestDAO tdao;
	public void setTdao(TestDAO tdao)
	{
		this.tdao = tdao;
	}
	
	@Transactional
	public Test insertTest(Test test)
	{
		return tdao.save(test);
	}
	
	 @Transactional
	    public String deleteTest(int testId)
	    {
	    	tdao.deleteById(testId);
	    	return "test Deleted";
	    }
}