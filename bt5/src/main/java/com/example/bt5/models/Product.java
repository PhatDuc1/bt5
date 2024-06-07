package com.example.bt5.models;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Product {
    private int id;

    @NotBlank(message = "ten san pham ko dc de trong")
    private String name;

    @Length(min=0, max=50, message = "ten hinh anh ko qua 50 ky tu")
    private String image;

    @NotNull(message = "gia san pham ko dc de trong")
    @Min(value=1, message="gia san pham ko dc nho hon 1")
    @Max(value=999999, message="gia san pham ko dc lon hon 999999")
    private long price;

    public Product() {
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}
