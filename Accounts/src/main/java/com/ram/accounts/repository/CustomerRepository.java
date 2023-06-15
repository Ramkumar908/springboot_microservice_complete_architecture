package com.ram.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.accounts.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {

}
