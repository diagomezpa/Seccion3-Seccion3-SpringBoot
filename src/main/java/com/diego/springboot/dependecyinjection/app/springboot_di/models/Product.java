package com.diego.springboot.dependecyinjection.app.springboot_di.models;

public class Product implements Cloneable {
    private Long id;
    private String name;
    private Long price;

    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    // @Override
    // public Product clone() {
    //     try {
    //         return (Product) super.clone();
    //     } catch (CloneNotSupportedException e) {
    //         throw new AssertionError();
    //     }
    // }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }
}
