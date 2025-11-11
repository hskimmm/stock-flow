package com.spring.stockflow.service.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.product.CreateProductDTO;
import com.spring.stockflow.dto.product.EditProductDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(Pagination pagination);

    ApiResponse<?> addProduct(@Valid CreateProductDTO createProductDTO);

    Product getProduct(Long id);

    ApiResponse<?> editProduct(@Valid EditProductDTO editProductDTO);

    ApiResponse<?> deleteProduct(Long id);

    int getTotalCount(Pagination pagination);
}
