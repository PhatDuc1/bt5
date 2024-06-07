package com.example.bt5.services;


import com.example.bt5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> listProduct= new ArrayList<>();

    public ProductService() {
        // this.listProduct.add(new Product(1, "San pham 1", "1.jpg", 29312));
        // this.listProduct.add(new Product (2, "San pham 2", "2.jpg", 124246));
    }
    public void add(Product newProduct) {

        listProduct.add(newProduct);
    }

    public List<Product> GetAll() { return listProduct; }

    public Product get(int id) { return listProduct.stream().filter(p->p.getId() == id).findFirst().orElse(null);}

        public void edit(Product editProduct) {}
    }
