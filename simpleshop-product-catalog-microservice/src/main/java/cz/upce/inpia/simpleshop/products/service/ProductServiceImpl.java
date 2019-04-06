package cz.upce.inpia.simpleshop.products.service;

import cz.upce.inpia.simpleshop.products.dao.ProductDao;
import cz.upce.inpia.simpleshop.products.dto.ProductDto;
import cz.upce.inpia.simpleshop.products.feign.InventoryClient;
import cz.upce.inpia.simpleshop.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final InventoryClient inventoryClient;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, InventoryClient inventoryClient) {
        this.productDao = productDao;
        this.inventoryClient = inventoryClient;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : productDao.findAll()) {
            Integer availableQuantity = inventoryClient.findById(product.getId());
            ProductDto productDto = convertToDto(product, availableQuantity);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductDto findById(Integer productId) {
        if (productDao.findById(productId).isPresent()) {
            Integer availableQuantity = inventoryClient.findById(productId);
            Product productById = productDao.findById(productId).get();
            return convertToDto(productById, availableQuantity);
        } else {
            throw new NoSuchElementException("Product with ID: " + productId + " was not found!");
        }
    }

    private ProductDto convertToDto(Product product, Integer availableAmount) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setQuantityAvailable(availableAmount);
        return productDto;
    }
}
