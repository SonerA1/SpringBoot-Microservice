package com.sonera1.stockmanagement.productservice.exception.exceptions;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.exception.enums.IFriendlyMessageCode;
import com.sonera1.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import lombok.Generated;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j // for make note
@Getter
public class ProductNotCreatedException extends RuntimeException{ // if we get error this class will work
    private final Language language;
    private final IFriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotCreatedException] -> message: {} developer message: {}", FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode), message);
    }
}
