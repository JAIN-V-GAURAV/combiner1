package com.combine.unicllg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class Combine1Application {

	public static void main(String[] args) {
		SpringApplication.run(Combine1Application.class, args);
	}
	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration= new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept","Authorization"," Origin,Accept","X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Tyoe","Accept","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);

	}
}
