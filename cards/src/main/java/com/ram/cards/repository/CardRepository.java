package com.ram.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.cards.model.Cards;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {
	
	Cards findByCustomerId(int id);

}
