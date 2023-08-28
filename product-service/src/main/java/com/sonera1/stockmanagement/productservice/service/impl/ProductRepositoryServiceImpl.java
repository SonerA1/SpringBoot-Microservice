package com.sonera1.stockmanagement.productservice.service.impl;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.excepsion.enums.FriendlyMessageCodes;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductAlreadyDeletedException;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductNotCreatedException;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductNotFoundException;
import com.sonera1.stockmanagement.productservice.repository.entity.Product;
import com.sonera1.stockmanagement.productservice.repository.entity.ProductRepository;
import com.sonera1.stockmanagement.productservice.request.ProductCreateRequest;
import com.sonera1.stockmanagement.productservice.request.ProductUpdatedRequest;
import com.sonera1.stockmanagement.productservice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service // business ların bulunduğunu belli etmek için
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements IProductRepositoryService {

    private final ProductRepository productRepository;
    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {
        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        try {
            Product product = Product.builder()
                    .productName(productCreateRequest.getProductName())
                    .quantity(productCreateRequest.getQuantity())
                    .price(productCreateRequest.getPrice())
                    .deleted(false)
                    .build();
            Product productResponse = productRepository.save(product);
            log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(),productResponse);
            return productResponse;
        }catch (Exception exception){
         throw new ProductNotCreatedException(language, FriendlyMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION, "product_request: "+ productCreateRequest.toString());
        }

    }

    @Override
    public Product getProduct(Language language, Long productId) {

        log.debug("[{}][getProduct] -> request productId: {}", this.getClass().getSimpleName(),productId);
        Product product = productRepository.getByProductIdAndDeletedFalse(productId);
        if (Objects.isNull(product)){
            throw new ProductNotFoundException(language,FriendlyMessageCodes.PRODUCT_NOT_FOUND_EXCEPTION,"Product not found for product id: " + productId);
        }
        log.debug("[{}] -> response: {}",this.getClass().getSimpleName(), product);
        return product;
    }

    @Override
    public List<Product> getProducts(Language language) {

        log.debug("[{}][getProducts]", this.getClass().getSimpleName());
        List<Product> products = productRepository.getAllByDeletedFalse();
        if (products.isEmpty()){
            throw new ProductNotFoundException(language,FriendlyMessageCodes.PRODUCT_NOT_FOUND_EXCEPTION, "Product Not Found");
        }
        log.debug("[{}][getProducts] -> response: {}",this.getClass().getSimpleName(),products);
        return products;
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdatedRequest productUpdatedRequest) {
        log.debug("[{}][updateProduct] -> request: {}", this.getClass().getSimpleName(),productUpdatedRequest);
        Product product = getProduct(language,productId);
        product.setProductName(productUpdatedRequest.getProductName());
        product.setQuantity(productUpdatedRequest.getQuantity());
        product.setPrice(productUpdatedRequest.getPrice());
        product.setProductCreatedDate(product.getProductCreatedDate());
        product.setProductUpdatedDate(new Date());

        Product productResponse= productRepository.save(product);
        log.debug("[{}][updateProduct] -> response: {}", this.getClass().getSimpleName(),productResponse);
        return productResponse;
    }

    @Override
    public Product deleteProduct(Language language, Long productId) {
        log.debug("[{}][deleteProduct] -> request productId: {}",this.getClass().getSimpleName(),productId);
        Product product;
        try{
            product = getProduct(language,productId);
            product.setDeleted(true);
            product.setProductUpdatedDate(new Date());
            Product productResponse = productRepository.save(product);
            log.debug("[{}][deleteProduct] -> response: {}", this.getClass().getSimpleName(),productResponse);
            return productResponse;
        }catch (ProductNotFoundException productNotFoundException){
            throw new ProductAlreadyDeletedException(language,FriendlyMessageCodes.PRODUCT_ALREADY_DELETED,"Product already deleted product id: " + productId);
        }
    }
}
