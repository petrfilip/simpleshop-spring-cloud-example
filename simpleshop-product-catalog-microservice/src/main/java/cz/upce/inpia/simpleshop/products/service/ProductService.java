package cz.upce.inpia.simpleshop.products.service;

import cz.upce.inpia.simpleshop.products.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(Integer productId);
}
