package de.ait_tr.g_38_jp_shop.exception_handling;

import de.ait_tr.g_38_jp_shop.exception_handling.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(FourthTestException.class)
    public ResponseEntity<Response> handleException(FourthTestException e) {
        Throwable childException = e.getCause();
        Response response = new Response(e.getMessage(),
                childException == null ? null : parseExceptionMessage(childException.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    private String parseExceptionMessage(String message) {
        return message;
    }

    @ExceptionHandler(ProductNotFoundByDeleteException.class)
    public ResponseEntity<Response> handleException(ProductNotFoundByDeleteException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Response> handleException(ProductNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ProductNotFoundByRestoreException.class)
    public ResponseEntity<Response> handleException(ProductNotFoundByRestoreException e) {
        Throwable childException = e.getCause();
        Response response = new Response(e.getMessage(),
                childException == null ? null : parseExceptionMessage(childException.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }


}
