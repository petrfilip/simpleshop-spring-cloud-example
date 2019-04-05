package cz.upce.inpia.simpleshop.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InpiaSimpleShopDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InpiaSimpleShopDiscoveryApplication.class, args);
    }

}

