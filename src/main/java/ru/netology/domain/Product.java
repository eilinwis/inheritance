package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class Product {
    private String name;
    private int price;
    private int id;

public Product (String name, int price, int id) {
    this.name = name;
    this.price = price;
    this.id = id;
    }


}
