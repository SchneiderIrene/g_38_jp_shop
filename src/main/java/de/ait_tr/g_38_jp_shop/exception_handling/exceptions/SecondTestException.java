package de.ait_tr.g_38_jp_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class SecondTestException extends RuntimeException{

    public SecondTestException(String message) {
        super(message);
    }
// 2 СПОСОБ обработки ошибок
// ПЛЮС - легко и быстро, без лишнего кода создаём глобальный
// обработчик ошибок, который будет работать для всех контроллеров сразу
// МИНУС - клиенту не передаётся детализированное сообщение об ошибке,
// что затрудняет анализ причин её возникновения
}