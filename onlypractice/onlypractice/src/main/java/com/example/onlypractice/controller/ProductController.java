package com.example.onlypractice.controller;

import com.example.onlypractice.entity.Product;
import com.example.onlypractice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return  productService.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
@GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }
@GetMapping("/product/{id}")
    public Product findProductById (@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName (@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return  productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }



}
