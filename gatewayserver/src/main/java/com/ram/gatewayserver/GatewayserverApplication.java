package com.ram.gatewayserver;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes()
		.route(p -> p
				.path("/geniustech/accounts/**")
				.filters(f -> f.rewritePath("/geniustech/accounts/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Respose-Time", new Date().toString()))
				.uri("lb://ACCOUNTS")).
		route(p -> p
				.path("/geniustech/cards/**")
				.filters(f -> f.rewritePath("/geniustech/cards/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Respose-Time", new Date().toString()))
				.uri("lb://CARDS")).
		route(p -> p
				.path("/geniustech/loans/**")
				.filters(f -> f.rewritePath("/geniustech/loans/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Respose-Time", new Date().toString()))
				.uri("lb://LOANS")).build();
		
	}

}
