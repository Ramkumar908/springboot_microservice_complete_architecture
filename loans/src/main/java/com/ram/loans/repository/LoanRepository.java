package com.ram.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.loans.entity.Loans;

@Repository
public interface LoanRepository  extends JpaRepository<Loans, Integer>{

	
	
	
}
