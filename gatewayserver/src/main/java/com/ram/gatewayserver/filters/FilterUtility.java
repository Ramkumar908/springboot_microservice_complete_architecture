package com.ram.gatewayserver.filters;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtility {
	
	public static final String CORRELATION_ID = "geniustech-correlation-id";

	public String getCorrelationId(HttpHeaders requestHeaders) {
		
		if(requestHeaders.get(CORRELATION_ID)!=null)
		{
			List<String> requestHeaderList =requestHeaders.get(CORRELATION_ID);
			return requestHeaderList.stream().findFirst().get();
		}
		else
		{
			return null;

		}

	}

	public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationID) {

  
		return this.setRequestHeader(exchange, CORRELATION_ID, correlationID);
	}

	public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name,String value) {
		
		return exchange.mutate().request(exchange.getRequest().mutate().header(name,value).build()).build();
	}

}
