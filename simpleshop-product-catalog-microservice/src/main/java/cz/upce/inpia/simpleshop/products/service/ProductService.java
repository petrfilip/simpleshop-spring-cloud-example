package cz.upce.inpia.simpleshop.products.service;

import cz.upce.inpia.simpleshop.products.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer productId);
}
