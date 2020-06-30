package com.moad2code.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouad2code.ecommerce.entity.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController extends CrudController<Product, Long>{

}
