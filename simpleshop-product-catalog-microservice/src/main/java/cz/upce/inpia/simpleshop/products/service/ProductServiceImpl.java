package cz.upce.inpia.simpleshop.products.service;

import cz.upce.inpia.simpleshop.products.dao.ProductDao;
import cz.upce.inpia.simpleshop.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        if (productDao.findById(productId).isPresent()) {
            return productDao.findById(productId).get();
        } else {
            throw new NoSuchElementException("Product with ID: " + productId + " was not found!");
        }
    }
}
