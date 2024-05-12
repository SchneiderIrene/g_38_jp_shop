package de.ait_tr.g_38_jp_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class ProductNotFoundByDeleteException extends RuntimeException{

    public ProductNotFoundByDeleteException(String message) {
        super(message);
    }

    public ProductNotFoundByDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
