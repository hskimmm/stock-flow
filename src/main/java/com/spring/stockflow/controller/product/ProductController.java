package com.spring.stockflow.controller.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.product.CreateProductDTO;
import com.spring.stockflow.dto.product.EditProductDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("menuActive", "product-list");
        return "product/product-list";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("menuActive", "product-add");
        return "product/product-add";
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addProduct(@Valid @ModelAttribute CreateProductDTO createProductDTO) {
        ApiResponse<?> response = productService.addProduct(createProductDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable(value = "id") Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("menuActive", "product-list");
        return "product/product-detail";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable(value = "id") Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("menuActive", "product-list");
        return "product/product-edit";
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> editProduct(@Valid @RequestBody EditProductDTO editProductDTO) {
        ApiResponse<?> response = productService.editProduct(editProductDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable(value = "id") Long id) {
        ApiResponse<?> response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
