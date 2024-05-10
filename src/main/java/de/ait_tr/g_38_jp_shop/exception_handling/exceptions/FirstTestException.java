package de.ait_tr.g_38_jp_shop.exception_handling.exceptions;

public class FirstTestException extends RuntimeException{

    public FirstTestException(String message) {
        super(message);
    }

    public FirstTestException(String message, Throwable cause) {
        super(message, cause);
    }
}
