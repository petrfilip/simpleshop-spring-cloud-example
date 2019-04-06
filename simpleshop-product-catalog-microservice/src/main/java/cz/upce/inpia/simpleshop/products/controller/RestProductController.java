package cz.upce.inpia.simpleshop.products.controller;

import cz.upce.inpia.simpleshop.products.dto.ProductDto;
import cz.upce.inpia.simpleshop.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin
public class RestProductController {

    private final ProductService productService;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public RestProductController(ProductService productService, LoadBalancerClient loadBalancerClient) {
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


}
