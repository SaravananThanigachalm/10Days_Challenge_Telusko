package com.telusko.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		ProductService service =context.getBean(ProductService.class);

		// Get all products from DB
		List<Product> products = service.getAllProducts();
		for(Product p : products){
			System.out.println(p);
		}

		// Getting a specific Product using its name
		Product prod = service.getProduct("Mac Studio");
		System.out.println(prod);

		// Search by place
		List<Product> productsAtPlace = service.getProductAtPlace("White");
		for(Product p : productsAtPlace){
			System.out.println(p);
		}

		// Warranty Expired
		List<Product> productsWarrantyExp = service.warrantyExp();
		for(Product p : productsWarrantyExp){
			System.out.println(p);
		}

		// Get all products containing specific text
		List<Product> productsContainingText = service.getProductWithText("black");
		for(Product p : productsContainingText){
			System.out.println(p);
		}
	}

}
