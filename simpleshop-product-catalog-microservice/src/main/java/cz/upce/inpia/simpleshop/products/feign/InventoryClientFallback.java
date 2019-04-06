package cz.upce.inpia.simpleshop.products.feign;

import org.springframework.stereotype.Component;

@Component
public class InventoryClientFallback implements InventoryClient {

    @Override
    public Integer findById(Integer productId) {
        return 0;
    }
}
