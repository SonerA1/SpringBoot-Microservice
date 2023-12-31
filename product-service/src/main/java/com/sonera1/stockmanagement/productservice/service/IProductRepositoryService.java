package com.sonera1.stockmanagement.productservice.service;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.repository.entity.Product;
import com.sonera1.stockmanagement.productservice.request.ProductCreateRequest;
import com.sonera1.stockmanagement.productservice.request.ProductUpdatedRequest;

import java.util.List;

public interface IProductRepositoryService {

    Product createProduct(Language language, ProductCreateRequest productCreateRequest);

    Product getProduct(Language language,Long productId);

    List<Product> getProducts(Language language);

    Product updateProduct(Language language, Long productId, ProductUpdatedRequest productUpdatedRequest);

    Product deleteProduct(Language language, Long productId);

}
