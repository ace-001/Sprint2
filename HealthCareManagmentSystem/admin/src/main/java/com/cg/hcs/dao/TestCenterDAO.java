package com.cg.hcs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.TestCenter;

public interface TestCenterDAO extends JpaRepository<TestCenter, Integer>
{
	public Optional<List<TestCenter>> findByCenterId(Integer centerId);
	public TestCenter findByCenterIdAndTestId(Integer centerId,Integer testId);
	
}
