package cz.upce.inpia.simpleshop.products.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;

    private String name;

    private String description;

    private Integer quantityAvailable;

}
