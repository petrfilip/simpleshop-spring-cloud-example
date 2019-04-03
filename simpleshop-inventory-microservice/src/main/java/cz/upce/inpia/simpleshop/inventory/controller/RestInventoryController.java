package cz.upce.inpia.simpleshop.inventory.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/inventory")
@CrossOrigin
public class RestInventoryController {

    @GetMapping("{productId}")
    public Integer getProductById(@PathVariable Integer productId) {
        return productId + 10;
    }

}
