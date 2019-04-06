package cz.upce.inpia.simpleshop.inventory.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/inventory")
@CrossOrigin
public class RestInventoryController {

    @Value("${inpia.inventory.test:default}")
    private String inpiaTestProperty;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping
    public String defaultMethod() {
        return inpiaTestProperty;
    }

    @GetMapping("{productId}")
    public Integer findById(@PathVariable Integer productId) {
        return serverPort;
    }

}
