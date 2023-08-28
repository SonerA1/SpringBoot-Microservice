package com.sonera1.stockmanagement.productcacheservice.service;

import com.sonera1.stockmanagement.productcacheservice.enums.Language;
import com.sonera1.stockmanagement.productcacheservice.repository.entity.Product;

public interface ProductRepositoryService {
    Product getProduct(Language language, Long productId);

    void deleteProducts(Language language);


}
