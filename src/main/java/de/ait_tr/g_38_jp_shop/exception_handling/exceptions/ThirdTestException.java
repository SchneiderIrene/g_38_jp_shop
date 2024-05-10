package de.ait_tr.g_38_jp_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class ThirdTestException extends RuntimeException{

    public ThirdTestException(String message) {
        super(message);
    }



}