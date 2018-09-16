package com.employee.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tanlian
 * @create 2018-09-16 17:20
 **/
@Slf4j
@ControllerAdvice
public class GlobusalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    void handleEception(Exception e) {
        log.error("Exception:", e);
        System.err.println(e);
    }
}
