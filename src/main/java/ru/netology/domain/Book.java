package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String author;

    public Book (){

    }

        public Book(String name, int price, int id, String author) {
        super(name, price, id);
        this.author = author;
    }
}
