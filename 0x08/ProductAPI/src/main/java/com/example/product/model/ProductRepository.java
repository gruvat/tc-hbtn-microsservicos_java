package com.example.product.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return this.list;
    }

    public Product getProductById(Integer id) {
        return this.list.stream()
            .filter( p -> p.getId().equals(id))
            .findFirst()
            .get();
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        Integer index = this.list.indexOf(s);
        this.list.add(index, s);
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        listOfProducts.stream()
            .forEach(this.list::add);
    }
}
