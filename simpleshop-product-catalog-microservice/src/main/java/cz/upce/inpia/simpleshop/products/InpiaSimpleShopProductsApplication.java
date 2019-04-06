package cz.upce.inpia.simpleshop.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class InpiaSimpleShopProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InpiaSimpleShopProductsApplication.class, args);
    }

}

