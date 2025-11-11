package com.spring.stockflow.service.product;

import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.product.CreateProductDTO;
import com.spring.stockflow.dto.product.EditProductDTO;
import com.spring.stockflow.exception.ProductNotFoundException;
import com.spring.stockflow.mapper.product.ProductMapper;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Transactional
    @Override
    public ApiResponse<?> addProduct(CreateProductDTO createProductDTO) {
        try {
            Integer initialStock = createProductDTO.getInitialStock();
            if (initialStock != null && initialStock > 0) {
                //초기 재고 있을 시 입고 내역 생성
            }

            String productCode = generateProductCode();

            Product product = Product.builder()
                    .productCode(productCode)
                    .productName(createProductDTO.getProductName())
                    .category(createProductDTO.getCategory())
                    .unit(createProductDTO.getUnit())
                    .safetyStock(createProductDTO.getSafetyStock())
                    .remarks(createProductDTO.getRemarks())
                    .build();
            productMapper.addProduct(product);

            return new ApiResponse<>(true, product.getProductName() + " 상품을 등록 하였습니다");
        } catch (DataAccessException e) {
            log.error("상품 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 등록중 오류가 발생하였습니다.");
        } catch (Exception e) {
            log.error("상품 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 등록중 오류가 발생하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Product getProduct(Long id) {
        if (id == null) {
            throw new ProductNotFoundException("상품이 존재하지 않습니다");
        }

        try {
            return productMapper.getProduct(id);
        } catch (DataAccessException e) {
            log.error("상품 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 조회중 오류가 발생하였습니다.");
        } catch (Exception e) {
            log.error("상품 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 조회중 오류가 발생하였습니다.");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> editProduct(EditProductDTO editProductDTO) {
        try {
            Product product = ModelMapperUtils.map(editProductDTO, Product.class);
            productMapper.editProduct(product);
            return new ApiResponse<>(true, product.getProductName() + " 상품 정보를 수정하였습니다");
        } catch (DataAccessException e) {
            log.error("상품 정보 수정(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 정보 수정중 오류가 발생하였습니다.");
        } catch (Exception e) {
            log.error("상품 정보 수정(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 정보 수정중 오류가 발생하였습니다.");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> deleteProduct(Long id) {
        if (id == null) {
            throw new ProductNotFoundException("상품이 존재하지 않습니다");
        }

        try {
            productMapper.deleteProduct(id);
            return new ApiResponse<>(true, "상품을 삭제하였습니다");
        } catch (DataAccessException e) {
            log.error("상품 삭제(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 삭제 중 오류가 발생하였습니다.");
        } catch (Exception e) {
            log.error("상품 삭제(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 삭제 중 오류가 발생하였습니다.");
        }
    }

    //상품 코드 생성
    private String generateProductCode() {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String prefix = "PRD-" + dateStr + "-";

        String lastCode = productMapper.findLastProductCodeByDate(dateStr);

        //오늘 등록된 상품 없을 경우 기본값 001, 오늘 등록된 상품 있을 경우 마지막 시퀀스 번호 가져와서 + 1 처리
        int sequence = 1;
        if (lastCode != null) {
            String lastSeq = lastCode.substring(lastCode.lastIndexOf("-") + 1);
            sequence = Integer.parseInt(lastSeq) + 1;
        }
        return prefix + String.format("%03d", sequence);
    }
}
