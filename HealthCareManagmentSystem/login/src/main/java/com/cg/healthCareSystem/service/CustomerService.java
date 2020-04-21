package com.cg.healthCareSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthCareSystem.dao.CustomerDao;
import com.cg.healthCareSystem.dto.Customer;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDao cdao;
	public void setCdao(CustomerDao cdao)
	{
		this.cdao = cdao;
	}
	
	@Transactional(readOnly = true)
	public Customer getCustomerById(String user_id)
	{
		return cdao.findById(user_id).get();
	}
	
	@Transactional
	public Customer addCustomer(Customer customer)
	{
		return cdao.save(customer);
	}
}
