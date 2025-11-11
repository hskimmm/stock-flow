package com.spring.stockflow.mapper.product;

import com.spring.stockflow.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProducts();
}
