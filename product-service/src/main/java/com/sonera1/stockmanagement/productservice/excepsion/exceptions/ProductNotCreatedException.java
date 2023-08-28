package com.sonera1.stockmanagement.productservice.excepsion.exceptions;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.excepsion.enums.IFriendlyMessageCode;
import com.sonera1.stockmanagement.productservice.excepsion.utils.FriendlyMessageUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j// log satırları için
@Getter
public class ProductNotCreatedException extends RuntimeException{

    private final Language language;
    private final IFriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode,String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotCreatedException] -> message: {} developer message:{}",FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode),message);
    }
}
