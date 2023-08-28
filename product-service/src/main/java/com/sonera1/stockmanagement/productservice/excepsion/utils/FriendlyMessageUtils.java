package com.sonera1.stockmanagement.productservice.excepsion.utils;

import com.sonera1.stockmanagement.productservice.enums.Language;
import com.sonera1.stockmanagement.productservice.excepsion.enums.IFriendlyMessageCode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*@Slf4j
@UtilityClass // class arka tarafta final olarak işaretlernir classdaki bütün methodlar static olarak işaretlerniyor
public class FriendlyMessageUtils {

    private static final String RESOURCE_BUNDLE_NAME = "FriendlyMessage";
    private static final String SPECIAL_CHARACTER="__";

    public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode){
        String messageKey = null;
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode; // -> friendlymessage: __ OK olacak şekilde
            return resourceBundle.getString(messageKey); //yukarıdakini döndür demek
        }catch (MissingResourceException missingResourceException){
            log.error("Friendly message not found for key: {}", messageKey);
            return null;

        }
    }

}*/

@Slf4j
@UtilityClass
public class FriendlyMessageUtils {

    private static final String RESOURCE_BUNDLE_NAME = "FriendlyMessage";
    private static final String SPECIAL_CHARACTER = "__";

    public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode) {
        String messageKey = null;
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode;
            return resourceBundle.getString(messageKey);
        } catch (MissingResourceException missingResourceException) {
            log.error("Friendly message not found for key: {}", messageKey);
            return null;
        }
    }
}
