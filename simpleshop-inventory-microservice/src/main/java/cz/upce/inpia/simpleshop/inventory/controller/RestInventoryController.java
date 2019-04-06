package cz.upce.inpia.simpleshop.inventory.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/inventory")
@CrossOrigin
public class RestInventoryController {

    @Value("${inpia.inventory.test:default}")
    private String inpiaTestProperty;

    @GetMapping
    public String defaultMethod() {
        return inpiaTestProperty;
    }

    @GetMapping("{productId}")
    public Integer getProductById(@PathVariable Integer productId) {
        return productId + 10;
    }

}
