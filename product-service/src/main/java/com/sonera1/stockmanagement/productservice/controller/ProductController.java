package com.sonera1.stockmanagement.productservice.controller;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.exception.enums.FriendlyMessageCodes;
import com.sonera1.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.sonera1.stockmanagement.productservice.repository.entity.Product;
import com.sonera1.stockmanagement.productservice.request.ProductCreateRequest;
import com.sonera1.stockmanagement.productservice.request.ProductUpdateRequest;
import com.sonera1.stockmanagement.productservice.response.FriendlyMessage;
import com.sonera1.stockmanagement.productservice.response.InternalApiResponse;
import com.sonera1.stockmanagement.productservice.response.ProductResponse;
import com.sonera1.stockmanagement.productservice.service.IProductRepositoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController // RESTFUL web service
@RequestMapping(value = "/api/1.0/product") // if we request URL and URL get answer we code
@RequiredArgsConstructor
public class ProductController {
    //service
    private final IProductRepositoryService productRepositoryService;

    //this method have a pathvariable annotation parameters. Pathvariable annotation is contact the other variable on
    // second parameters is ProductCreateRequest - we add @requestbody annotation and detects and processes request to web service
    @ResponseStatus(HttpStatus.CREATED)// Response status - response of the web service controlled the returing http status.-http status indicates web service result and helps to understand
    @PostMapping(value = "/{language}/create") //postMapping -  allows a web service to detect and process httppost requests made to a url. It is a subclass of RequestMapping.
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language") Language language,
                                                              @RequestBody ProductCreateRequest productCreateRequest) {
        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        Product product = productRepositoryService.createProduct(language, productCreateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK) // 202 get response HTTP Status for ok // for get post
    @GetMapping(value = "/{language}/get/{productId}")
    public InternalApiResponse<ProductResponse> getProduct(@PathVariable("language") Language language,
                                                           @PathVariable("productId") Long productId){
        log.debug("[{}][getProduct] -> request productId: {}", this.getClass().getSimpleName(),productId);
        Product product = productRepositoryService.getProduct(language,productId);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][getProduct] -> response: {}", this.getClass().getSimpleName(),product);
        return InternalApiResponse.<ProductResponse>builder()
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{language}/update/{productId}") // for update post
    public InternalApiResponse<ProductResponse> updateProduct(@PathVariable("language")Language language,
                                                              @PathVariable("productId") Long productId,
                                                              @RequestBody ProductUpdateRequest productUpdateRequest){// this method make 3 parameters first language and others pathvariable
        log.debug("[{}][updateProduct] -> request: {} {}", this.getClass().getSimpleName(),productId,productUpdateRequest);
        Product product = productRepositoryService.updateProduct(language,productId,productUpdateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][updateProduct] -> request: {}", this.getClass().getSimpleName(),productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_UPDATED))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();

    }
    @ApiOperation(value = "This endpoint get all product.") //for springfox saeled:  swaggerApı documents method.Specifies a RESTAPI description and features
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{language}/products")
    public InternalApiResponse<List<ProductResponse>> getProducts(@PathVariable("language") Language language){
        log.debug("{[]}[getProducts]",this.getClass().getSimpleName());
        List<Product> products = productRepositoryService.getProducts(language);
        List<ProductResponse> productResponses = convertProductResponseList(products);
        log.debug("{[]}[getProducts] -> response: {}",this.getClass().getSimpleName(), productResponses);

        return InternalApiResponse.<List<ProductResponse>>builder()
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponses)
                .build();
    }

    //for delete post//
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{language}/delete/{productId}")
    public InternalApiResponse<ProductResponse> deleteProduct(@PathVariable("language") Language language,
                                                              @PathVariable("productId") Long productId){
        log.debug("{[]}[deleteProduct] -> request productId: {}", this.getClass().getSimpleName(), productId);
        Product product = productRepositoryService.deleteProduct(language,productId);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("{[]}[deleteProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_DELETED))
                        .build())
                .httpStatus(HttpStatus.OK)
                .hasError(false)
                .payload(productResponse)
                .build();
    }


    private List<ProductResponse> convertProductResponseList(List<Product> productList){
        return productList.stream()
                .map(arg -> ProductResponse.builder()
                        .productId(arg.getProductId())
                        .productName(arg.getProductName())
                        .quantity(arg.getQuantity())
                        .price(arg.getPrice())
                        .productCreatedDate(arg.getProductCreateDate().getTime())
                        .productUpdatedDate(arg.getProductUpdatedDate().getTime())
                        .build())
                .collect(Collectors.toList());

    }

    private ProductResponse convertProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .productCreatedDate(product.getProductCreateDate().getTime())
                .productUpdatedDate(product.getProductUpdatedDate().getTime())
                .build();
    }

}
