package cz.upce.inpia.simpleshop.edge;

import cz.upce.inpia.simpleshop.edge.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class InpiaSimpleShopEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(InpiaSimpleShopEdgeApplication.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

}

