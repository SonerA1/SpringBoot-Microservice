package com.sonera1.stockmanagement.productcacheservice.service;

import com.sonera1.stockmanagement.productcacheservice.enums.Language;
import com.sonera1.stockmanagement.productcacheservice.feign.products.ProductServiceFeignClient;
import com.sonera1.stockmanagement.productcacheservice.repository.ProductRepository;
import com.sonera1.stockmanagement.productcacheservice.repository.entity.Product;
import com.sonera1.stockmanagement.productcacheservice.response.ProductResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository productRepository;
    private final ProductServiceFeignClient productServiceFeignClient;

    @Override
    public Product getProduct(Language language, Long productId) {
        Product product;
        try{
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (optionalProduct.isPresent()){
                product = optionalProduct.get();
            }else {
                log.info("Data came from product-service");
                product = new Product();
                ProductResponse response = productServiceFeignClient.getProduct(language,productId).getPayload();

                product.setProductId(response.getProductId());
                product.setProductName(response.getProductName());
                product.setPrice(response.getPrice());
                product.setQuantity(response.getQuantity());
                product.setProductCreatedDate(response.getProductCreatedDate());
                product.setProductUpdatedDate(response.getProductUpdatedDate());
                productRepository.save(product);
            }
        }catch (FeignException.FeignClientException.NotFound exception){
            throw new NotFoundException("Product not found for product id: " + productId);
        }
        return product;
    }

    @Override
    public void deleteProducts(Language language) {
        productRepository.deleteAll();
        log.info("Deleted All Product");

    }
}
