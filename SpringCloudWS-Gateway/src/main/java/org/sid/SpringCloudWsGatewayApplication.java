package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudWsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWsGatewayApplication.class, args);
	}
	
	/*@Bean
	RouteLocator routeRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE").id("r1"))
				.route((r)->r.path("/products/**").uri("lb://PRODUCT-SERVICE").id("r2"))
				.build();		
	}*/
	
	/*
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r->r.path("/restcountries/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key", "fe5e774996msh4eb6e863d457420p1d2ffbjsnee0617ac5078")
								.rewritePath("/restcountries/(?<segment>.*)","/${segment}")
								.hystrix(h->h.setName("rest-countries")
									.setFallbackUri("forward:/restCountriesFallback"))
								)
						.uri("https://restcountries-v1.p.rapidapi.com").id("countries")
						)
						.route(r->r.path("/muslimsalat/**")
								.filters(f->f
										.addRequestHeader("x-rapidapi-host","muslimsalat.p.rapidapi.com")
										.addRequestHeader("x-rapidapi-key", "fe5e774996msh4eb6e863d457420p1d2ffbjsnee0617ac5078")
										.rewritePath("/muslimsalat/(?<segment>.*)","/${segment}")
										.hystrix(h->h.setName("muslimsalat")
											.setFallbackUri("forward:/muslimsalatFallback"))
			)
			.uri("https://muslimsalat.p.rapidapi.com").id("countries")
			)
			.build();
	}*/
	
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
		
	}
}
