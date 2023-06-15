package com.ram.accounts.service.model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ram.accounts.entity.Customers;

@FeignClient("cards")
public interface CardFeign {
	
	@RequestMapping(method = RequestMethod.POST,value = "getcards",consumes = "application/json")
	List<Cards> getAllCardDetail(@RequestBody Customers customers);

}
