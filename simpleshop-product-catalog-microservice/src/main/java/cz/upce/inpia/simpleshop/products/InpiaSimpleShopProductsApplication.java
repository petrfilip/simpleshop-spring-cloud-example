package cz.upce.inpia.simpleshop.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InpiaSimpleShopProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InpiaSimpleShopProductsApplication.class, args);
    }

}

