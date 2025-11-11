package com.spring.stockflow.service.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.product.CreateProductDTO;
import com.spring.stockflow.dto.product.EditProductDTO;
import com.spring.stockflow.response.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    ApiResponse<?> addProduct(@Valid CreateProductDTO createProductDTO);

    Product getProduct(Long id);

    ApiResponse<?> editProduct(@Valid EditProductDTO editProductDTO);
}
