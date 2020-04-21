package com.cg.healthCareSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthCareSystem.dto.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> 
{

}
