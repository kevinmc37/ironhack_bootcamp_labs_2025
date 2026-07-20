package com.ironhack.lab_java_springboot_rest_api_es.service;

import com.ironhack.lab_java_springboot_rest_api_es.dto.ProductRequestDTO;
import com.ironhack.lab_java_springboot_rest_api_es.dto.ProductResponseDTO;
import com.ironhack.lab_java_springboot_rest_api_es.exception.PriceRangeNotValidException;
import com.ironhack.lab_java_springboot_rest_api_es.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product((long)products.size(), "Laptop", "Electronics", 199.99, 6));
        products.add(new Product((long)products.size(), "TV", "Electronics", 499.99, 7));
        products.add(new Product((long)products.size(), "Airpods", "Electronics", 39.99, 3));
        products.add(new Product((long)products.size(), "Wood Table", "Decoration", 299.99, 98));
        products.add(new Product((long)products.size(), "Chocolate", "Edible", 2.99, 45));
        products.add(new Product((long)products.size(), "Gift Paper", "Paper", 0.99, -23));
        products.add(new Product((long)products.size(), "Cupcake", "Edible", 6.99, 0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) { return product; }
        }
        return null;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) { result.add(product); }
        }
        return result;
    }

    public List<Product> getProductsByPriceRange(double price1, double price2) {
        if (price1 > price2) { throw new PriceRangeNotValidException(price1, price2); }
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            double productPrice = product.getPrice();
            if (productPrice >= price1 && productPrice <= price2) { result.add(product); }
        }
        return result;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product newProduct = new Product((long)products.size(), productRequestDTO.getName(),
                productRequestDTO.getCategory(), productRequestDTO.getPrice(), productRequestDTO.getQuantity());
        products.add(newProduct);
        return new ProductResponseDTO(newProduct.getId(), newProduct.getName(), newProduct.getCategory(),
                newProduct.getPrice(), newProduct.getQuantity());
    }

    public void deleteProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            Product productFromList = products.get(i);
            if (productFromList.getName().equals(name)) {
                products.remove(i);
                break;
            }
        }
    }

    public Product updateProduct(String name, ProductRequestDTO productRequestDTO) {
        Product productFromList = getProductByName(name);
        if (productFromList == null) { return null; }
        productFromList.setName(productRequestDTO.getName());
        productFromList.setCategory(productRequestDTO.getCategory());
        productFromList.setPrice(productRequestDTO.getPrice());
        return productFromList;
    }
}