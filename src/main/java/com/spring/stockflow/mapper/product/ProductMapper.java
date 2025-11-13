package com.spring.stockflow.mapper.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.history.InventoryHistoryDTO;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProducts(Pagination pagination);

    String findLastProductCodeByDate(String dateStr);

    void addProduct(Product product);

    Product getProduct(Long id);

    void editProduct(Product product);

    void deleteProduct(Long id);

    int getTotalCount(Pagination pagination);

    List<InventoryHistoryDTO> getProductHistory(Long id);
}
