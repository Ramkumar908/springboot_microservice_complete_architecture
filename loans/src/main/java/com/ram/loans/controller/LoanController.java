package com.ram.loans.controller;

import java.time.LocalTime;
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
import com.ram.loans.entity.Loans;
import com.ram.loans.entity.LoansConfigService;
import com.ram.loans.entity.Properties;
import com.ram.loans.repository.LoanRepository;

@RestController
public class LoanController {
	
	private static final Logger logger =LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanRepository loanRepository;
	
	
	@Autowired
	LoansConfigService loanService;
	
	
	@PostMapping("/postLoan")
	public Loans  postLoans(@RequestBody Loans loans)
	{
		
		System.out.println("inside postLoan function");
		return loanRepository.save(loans);
		
	}

	
	@PostMapping("/getLoans")
	public List<Loans> getAllLons(@RequestBody com.ram.loans.entity.Customer Customer)
	{

		logger.info("Application Started in  Loan GetLoans {} ");

		LocalTime time = LocalTime.now();
		System.out.println("********** -"+time);
//		System.out.println("correlation Id () {}."+correlationId);
		return loanRepository.findAll();
	}
	
	@GetMapping("/get/loans")
	public String getLoansProperties() throws JsonProcessingException
	{
		ObjectWriter oj=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(loanService.getMsg(),loanService.getBuildVersion(),loanService.getMailDetails(),loanService.getActiveBranches());
		String jsonStr=oj.writeValueAsString(properties);
		return jsonStr;
	}
}
