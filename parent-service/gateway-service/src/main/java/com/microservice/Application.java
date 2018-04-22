package com.microservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.filters.ErrorFilter;
import com.microservice.filters.PostFilter;
import com.microservice.filters.PreFilter;
import com.microservice.filters.RouteFilter;


@SpringBootApplication
@EnableZuulProxy
@RestController
public class Application {	

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}
	
}
