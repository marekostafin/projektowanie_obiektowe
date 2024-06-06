package com.example.zadanie8.ui.product;

import androidx.annotation.NonNull;

public class Product {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
