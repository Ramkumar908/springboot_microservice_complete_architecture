package com.ram.gatewayserver.filters;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class TraceFilter implements GlobalFilter {

	private static final Logger logger=LoggerFactory.getLogger(TraceFilter.class);
	
	@Autowired
	FilterUtility filterUtility;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		HttpHeaders requestHeaders=exchange.getRequest().getHeaders();
		if(isCorrelationIdPresent(requestHeaders))
		{
		  logger.debug("geniusTech CorrelationId found in tracing filter: {}.",filterUtility.getCorrelationId(requestHeaders));	
		}
		else
		{
			String correlationID=generateCorrelationId();
			exchange =filterUtility.setCorrelationId(exchange,correlationID);
			  logger.debug("geniusTech CorrelationId generated in tracing filter: {}.",correlationID);	

		}
		return chain.filter(exchange);
	}
	private String generateCorrelationId() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}
	private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
		if(filterUtility.getCorrelationId(requestHeaders)!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

}
