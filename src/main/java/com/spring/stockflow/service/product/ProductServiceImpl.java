package com.spring.stockflow.service.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts() {
        try {
            return productMapper.getProducts();
        } catch (DataAccessException e) {
            log.error("상품 목록 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 목록 조회중 오류가 발생하였습니다.");
        } catch (Exception e) {
            log.error("상품 목록 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 목록 조회중 오류가 발생하였습니다.");
        }
    }
}
