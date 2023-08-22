package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IParseModel<Product> {
    private long id;
    private String name;
    private String description;
    private double price;
    private ECategory category;


    @Override
    public Product parse(String line) {
//        String[] items = line.split(",");
//        Product p = new Product(Long.parseLong(items[0]), items[1]);
//        return p;
        return null;
    }
}
