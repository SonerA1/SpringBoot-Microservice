package com.sonera1.stockmanagement.productcacheservice.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
//Bu yapı ile resapi service ile responseu hata mesajı success mesajı httpStatus gibi alanları kapsar. farklı bir alan ihtiyacı olursa da buraya eklenir
public class InternalApiResponse<T> {

    private FriendlyMessage friendlyMessage; // mesajın title ve descriptionu bulunur
    private T payload; // T diyerek generic type olduğunu belirttik
    private boolean hasError; // error oluşup oluşmadığını tutar
    private List<String> errorMessage; // hata mesajını ne olduğunu içericek
    private HttpStatus httpStatus; // notfound bad request gibi statusleri tutar



}
