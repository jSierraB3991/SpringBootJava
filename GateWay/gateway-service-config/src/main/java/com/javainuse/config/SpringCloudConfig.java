package com.javainuse.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
        		//http://localhost:8080/product
                .route(r -> r.path("/product/**")
                        .uri("http://localhost:8081")
                        .id("products"))
                
                //http://localhost:8080/user
                .route(r -> r.path("/user/**")
                        .uri("http://localhost:8082/")
                        .id("consumerModule"))
                .build();
    }

}