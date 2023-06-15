package com.ram.cards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ram.cards.model.Cards;
import com.ram.cards.model.CardsConfigServer;
import com.ram.cards.model.Customer;
import com.ram.cards.model.Property;
import com.ram.cards.repository.CardRepository;

@RestController
public class CardController {
	
	private static final Logger Logger =LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	CardsConfigServer cardService;
	
	
	@PostMapping("/postCard")
	public Cards postAllCard(@RequestBody Cards card)
	{
		return cardRepository.save(card);
	}
	
	@PostMapping("/getCard")
	public Cards postAllCard1(@RequestBody Cards card)
	{
		
		System.out.println("get inside card By id "+card.getCustomerId());
		Cards card1=cardRepository.findByCustomerId(card.getCustomerId());
		System.out.println(card1.toString());
		if(card1!=null)
		{
			return card1;
		}
		else
		{
			
			return null;
		}
		
	}
	
	@PostMapping("/getcards")
	public List<Cards> getAllCards(@RequestBody Customer customer)
	{
		Logger.info("Application Started in  Cards getCards {} ");
		return cardRepository.findAll();
	}
	
	@GetMapping("/get/cardProperty")
	public String getCardDefaultProperty() throws JsonProcessingException
	{
		ObjectWriter ob=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Property property=new Property(cardService.getMsg(),cardService.getBuildVersion(),cardService.getMailDetails(),cardService.getActiveBranches());
		String jsonStr=ob.writeValueAsString(property);
		return jsonStr;
	}
	

}
