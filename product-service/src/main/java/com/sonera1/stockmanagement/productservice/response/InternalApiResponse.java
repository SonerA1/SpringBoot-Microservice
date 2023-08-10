package com.sonera1.stockmanagement.productservice.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class InternalApiResponse<T> {
    // rest API one type / Response error message- success mesage - http status needed all in
    private FriendlyMessage friendlyMessage;
    private T payload; // generic class
    private boolean hasError;
    private List<String> errorMessages;
    private HttpStatus httpStatus; // for a not found, ok,created


}
