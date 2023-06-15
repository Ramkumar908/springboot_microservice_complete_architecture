package com.ram.accounts.controller;

import java.lang.annotation.Retention;
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
import com.ram.accounts.entity.AccountConfigService;
import com.ram.accounts.entity.Accounts;
import com.ram.accounts.entity.Customers;
import com.ram.accounts.entity.Properties;
import com.ram.accounts.repository.AccountRepository;
import com.ram.accounts.repository.CustomerRepository;
import com.ram.accounts.service.model.CardFeign;
import com.ram.accounts.service.model.Cards;
import com.ram.accounts.service.model.CustomerDetails;
import com.ram.accounts.service.model.LoanFeign;
import com.ram.accounts.service.model.Loans;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class AccountController {
	
	private static final Logger Logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountConfigService configService;
	
	@Autowired
	LoanFeign LoanFeign;
	
	@Autowired
	CardFeign cardFeign;
	
	@PostMapping("/addAccount")
	public Accounts addAccount(@RequestBody Accounts accounts)
	{
		System.out.println("Inside addAccount function");
		return accountRepository.save(accounts);
		
		
	}
	
	
	@PostMapping("/addCustomer")
	public Customers addCustomer(@RequestBody Customers customer)
	{
		System.out.println("Inside addCustomer function");
		return customerRepository.save(customer);
		
		
	}
	
	@PostMapping("/getAccount")
	public Accounts getAccountDetail(@RequestBody Accounts accounts)
	{
		
		Accounts accountsq=accountRepository.findByCustomerId(accounts.getCustomerId());
		if(accountsq!=null)
		{
			return accountsq;
		}
		else
		{
			return null;
		}
		
	}
	
	@GetMapping("/get/properties")
	public String getAccountProdProperties() throws JsonProcessingException
	{
		System.out.println("Calling from the getAccountProperties");
		ObjectWriter ob=new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties=new Properties(configService.getMsg(),configService.getBuildVersion(),
				configService.getMailDetails(),configService.getActiveBranches());
		String jsonstr=ob.writeValueAsString(properties);
		return jsonstr;
		
	}
	@PostMapping("/getCustomerDetails")
	@Retry(name="retryForCustomerDetails",fallbackMethod = "getCustomerDetailFallbackMethod" )
//	@CircuitBreaker(name="detailsForCustomerSupportApp",fallbackMethod = "getCustomerDetailFallbackMethod")
	public CustomerDetails getAllCustomerDetails( @RequestBody Customers customers)
	{
		
		Logger.info("Application Started in  Accounts CustomerDetails {} ");
	   CustomerDetails customerDetails =new CustomerDetails();
	   Accounts  accounts =accountRepository.findByCustomerId(customers.getCustomerId());
	   List<Loans> loans= LoanFeign.getLoanDetails(customers);
	   List<Cards> cards =cardFeign.getAllCardDetail(customers);
	   customerDetails.setAccounts(accounts);  
	   customerDetails.setLoans(loans);
	   customerDetails.setCards(cards);
	   return customerDetails;
	}
	
	@GetMapping("/"
			+ "")
	@RateLimiter(name="sayHello",fallbackMethod = "sayHelloFallbackMethod")
	public String sayHelloMethod()
	{
		return "Hello welcome to GeniusTech";
	}
	private String sayHelloFallbackMethod(Throwable t)
	{
		return "Hi welcome to the GeniusTech";
		
	}

	private CustomerDetails getCustomerDetailFallbackMethod(Customers customer ,Throwable t)
	{
		CustomerDetails customerDetails=new CustomerDetails();
		Accounts accounts =accountRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans=LoanFeign.getLoanDetails(customer);
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		return customerDetails;
	}
}
