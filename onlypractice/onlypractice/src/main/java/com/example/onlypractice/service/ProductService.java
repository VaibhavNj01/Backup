package com.example.onlypractice.service;

import com.example.onlypractice.entity.Product;
import com.example.onlypractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return (Product) productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "product removed " + id;

    }

    public Product updateProduct(Product product) {
        Product existingproduct = productRepository.findById(product.getId()).orElse(null);
        existingproduct.setName(product.getName());
        existingproduct.setQuantity(product.getQuantity());
        existingproduct.setPrice(product.getPrice());
        return productRepository.save(existingproduct);
    }

}
