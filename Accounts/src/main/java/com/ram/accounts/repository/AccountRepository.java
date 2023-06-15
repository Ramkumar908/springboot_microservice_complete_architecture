package com.ram.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.accounts.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {

	Accounts findByCustomerId(int id);
}
