package com.ironhack.lab_java_springboot_rest_api_es.controller;

import com.ironhack.lab_java_springboot_rest_api_es.dto.ProductRequestDTO;
import com.ironhack.lab_java_springboot_rest_api_es.dto.ProductResponseDTO;
import com.ironhack.lab_java_springboot_rest_api_es.exception.APIKeyNotFoundException;
import com.ironhack.lab_java_springboot_rest_api_es.model.Product;
import com.ironhack.lab_java_springboot_rest_api_es.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService; // Inyección de dependencias por constructor
    private static final String API_KEY = "123456";

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    protected static void validateAPIKey(String apiKey) {
        if (!API_KEY.equals(apiKey)) {
            throw new APIKeyNotFoundException(apiKey);
        }
    }

    @GetMapping()
    public List<Product> getAllProducts(@RequestHeader("API-Key") String apiKey) {
        validateAPIKey(apiKey);
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@RequestHeader("API-Key") String apiKey, @PathVariable String name) {
        validateAPIKey(apiKey);
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestHeader("API-Key") String apiKey, @PathVariable String category) {
        validateAPIKey(apiKey);
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestHeader("API-Key") String apiKey, @RequestParam(defaultValue = "0") double min, @RequestParam double max) {
        validateAPIKey(apiKey);
        List<Product> products = productService.getProductsByPriceRange(min, max);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestHeader("API-Key") String apiKey, @RequestBody @Valid ProductRequestDTO product) {
        validateAPIKey(apiKey);
        ProductResponseDTO responseDTO = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteProduct(@RequestHeader("API-Key") String apiKey, @PathVariable String name) {
        validateAPIKey(apiKey);
        productService.deleteProduct(name);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{name}")
    public Product updateProduct(@RequestHeader("API-Key") String apiKey, @PathVariable String name, @RequestBody @Valid ProductRequestDTO product) {
        validateAPIKey(apiKey);
        return productService.updateProduct(name, product);
    }
}
