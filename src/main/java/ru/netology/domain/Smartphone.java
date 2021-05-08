package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String producer;

    public Smartphone(){

    }

    public Smartphone(String name, int price, int id, String producer) {
        super(name, price, id);
        this.producer = producer;

    }
}
