package de.ait_tr.g_38_jp_shop.exception_handling.exceptions;

import de.ait_tr.g_38_jp_shop.exception_handling.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FirstTestException extends RuntimeException{

    public FirstTestException(String message) {
        super(message);
    }

    public FirstTestException(String message, Throwable cause) {
        super(message, cause);
    }

    //для использования в только в  контроллерах
    //в котроллере создать такой метод, логику if не пишем в методах котроллера,
    // прописываем в сервисе, там выбрасывакм свое исключение,
    // но этот метод должен быть в котроллере
//    @ExceptionHandler(FirstTestException.class)
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    public Response handleException (FirstTestException e){
//        return  new Response(e.getMessage());
//    }

    // 1 СПОСОБ обработки ошибок

// ПЛЮС - у нас есть обработчик ошибок для контроллера (всех его методов)

// Мы можем точечно настраивать обработчик для данного конкретного контроллера,

// если нам требуется разная логика обработки того же самого исключения

// в разных контроллерах.

// МИНУС - если нам не требуется разной логики обработки ошибок,

// нам придётся писать такой обработчик в каждом контроллере.
}
