package com.sonera1.stockmanagement.productcacheservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendlyMessage {
    private String title; // title error succes titlerını alır
    private String description; // productnotcreated ve productsuccsesfly created gibi açıklamaları içierir
    private String buttonPositive; // butonun durmunu belirleyecek alan

}
