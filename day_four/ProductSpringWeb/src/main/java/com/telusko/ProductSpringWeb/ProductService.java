package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDB db;

    public void addProduct(Product p){
        db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public Product getProduct(String name){
        return db.findByName(name);
    }


    public List<Product> getProductAtPlace(String place) {
        return db.findByPlaceContainingIgnoreCase(place);
    }

    public List<Product> warrantyExp() {
        int currentYr = Year.now().getValue();
        return db.findByWarrantyLessThan(currentYr);
    }

    public List<Product> getProductWithText(String text) {
        return db.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(text, text, text);
    }

    public List<Product> getProductAtType(String type) {
        return db.findByTypeContainingIgnoreCase(type);
    }
}
