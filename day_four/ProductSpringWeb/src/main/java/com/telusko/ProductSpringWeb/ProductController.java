package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }
    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name){
        return service.getProduct(name);
    }
    @GetMapping("/product/place/{place}")
    public List<Product> getProductByPlace(@PathVariable String place){
        return service.getProductAtPlace(place);
    }
    @GetMapping("/product/type/{type}")
    public List<Product> getProductByType(@PathVariable String type){
        return service.getProductAtType(type);
    }
    @GetMapping("/product/warranty-exp")
    public List<Product> getWarrantyExp(){
        return service.warrantyExp();
    }
    @GetMapping("/product/search-any/{text}")
    public List<Product> getProductContainingText(@PathVariable String text){
        return service.getProductWithText(text);
    }
    @PostMapping("/product")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }
}
