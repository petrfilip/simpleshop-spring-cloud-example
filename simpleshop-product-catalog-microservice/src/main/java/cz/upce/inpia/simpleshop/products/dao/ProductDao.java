package cz.upce.inpia.simpleshop.products.dao;

import cz.upce.inpia.simpleshop.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
