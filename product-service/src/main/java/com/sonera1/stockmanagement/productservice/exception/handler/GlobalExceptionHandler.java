package com.sonera1.stockmanagement.productservice.exception.handler;

import com.sonera1.stockmanagement.productservice.exception.enums.FriendlyMessageCodes;
import com.sonera1.stockmanagement.productservice.exception.exceptions.ProductAlreadyDeletedException;
import com.sonera1.stockmanagement.productservice.exception.exceptions.ProductNotCreatedException;
import com.sonera1.stockmanagement.productservice.exception.exceptions.ProductNotFoundException;
import com.sonera1.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.sonera1.stockmanagement.productservice.response.FriendlyMessage;
import com.sonera1.stockmanagement.productservice.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice // for exception handling
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)// if product not created for bad request. request not send normaly and feedback exception
    @ExceptionHandler(ProductNotCreatedException.class)// for all handler methods we will add Handler anataions
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception) {
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public InternalApiResponse<String> handlerProductNotFoundException(ProductNotFoundException exception){ // for ProductnotfoundException
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.NOT_FOUND) // http 404 not found
                .hasError(true) // for error
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();

    }

    // for alreadyDeleted methotd
    @ResponseStatus(HttpStatus.BAD_REQUEST) //bad request 400 status code
    @ExceptionHandler(ProductAlreadyDeletedException.class)
    public InternalApiResponse<String> handleProductAlreadyDeletedException(ProductAlreadyDeletedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessages(Collections.singletonList(exception.getMessage()))
                .build();
    }
}



