package com.sonera1.stockmanagement.productservice.excepsion.handler;

import com.sonera1.stockmanagement.productservice.excepsion.enums.FriendlyMessageCodes;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductAlreadyDeletedException;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductNotCreatedException;
import com.sonera1.stockmanagement.productservice.excepsion.exceptions.ProductNotFoundException;
import com.sonera1.stockmanagement.productservice.excepsion.utils.FriendlyMessageUtils;
import com.sonera1.stockmanagement.productservice.response.FriendlyMessage;
import com.sonera1.stockmanagement.productservice.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice//exception handling yapabilmek için bu eklentiyi kullanıyoruz
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // ortada bir request varken product oluşmaması bad request olarak tanımlanır
    @ExceptionHandler(ProductNotCreatedException.class) //
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode())) // eğer bir product create edilemezse mesaj bilgisini yaz
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))// gelen liste mutable olarak gelir ve liste değiştirilemez ve singleton halinde kalır
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public InternalApiResponse<String> handleProductNotFoundException(ProductNotFoundException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.NOT_FOUND)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductAlreadyDeletedException.class)
    public InternalApiResponse<String> handleProductAlreadyDeletedException(ProductAlreadyDeletedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))
                .build();
    }
}
