package cz.upce.inpia.simpleshop.products.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("inpia-simple-shop-inventory-microservice")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory/{productId}")
    Integer findById(@PathVariable("productId") Integer productId);
}