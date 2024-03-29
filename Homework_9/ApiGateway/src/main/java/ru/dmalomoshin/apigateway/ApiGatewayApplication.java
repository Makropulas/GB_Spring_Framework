package ru.dmalomoshin.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    // Этот бин нужно использовать, если не настроена маршрутизация в application.yaml
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("Tasks", r -> r.path("/tasks/**")
//                        .uri("http://localhost:8001/"))
//                .route("Books", r -> r.path("/books/**")
//                        .uri("http://localhost:8002/")).build();
//    }

}
