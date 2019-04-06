package cz.upce.inpia.simpleshop.products.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import cz.upce.inpia.simpleshop.products.dto.ProductDto;
import cz.upce.inpia.simpleshop.products.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin
public class RestProductController {

    private final ProductServiceImpl productService;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public RestProductController(ProductServiceImpl productService, LoadBalancerClient loadBalancerClient) {
        this.productService = productService;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("{productId}")
    public ProductDto getProductById(@PathVariable Integer productId) {
        return productService.findById(productId);
    }

    @GetMapping("inventory-load-balancing-test")
    public ServiceInstance getInventoryServices() {
        return loadBalancerClient.choose("inpia-simple-shop-inventory-microservice");
    }

    @GetMapping("hystrix-test")
    @HystrixCommand(fallbackMethod = "testHystrixFallback")
    public String testHystrix() {
        throw new NotImplementedException();
    }

    public String testHystrixFallback() {
        return "Fallback method!";
    }

}
