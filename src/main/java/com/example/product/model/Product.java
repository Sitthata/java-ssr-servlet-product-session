package com.example.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product {
    private int id;
    private String title;
    private String description;
}
