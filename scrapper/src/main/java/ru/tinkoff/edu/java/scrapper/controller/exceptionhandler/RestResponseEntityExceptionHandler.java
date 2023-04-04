package ru.tinkoff.edu.java.scrapper.controller.exceptionhandler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tinkoff.edu.java.scrapper.dto.response.ApiErrorResponse;

import java.util.Arrays;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse res = new ApiErrorResponse(
            "Invalid request parameters",
            "400",
            ex.getClass().getName(),
            ex.getMessage(),
            Arrays.stream(ex.getStackTrace()).map(String::valueOf).toList()
        );

        return handleExceptionInternal(ex, res, headers, HttpStatusCode.valueOf(400), request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiErrorResponse res = new ApiErrorResponse(
            "Invalid request parameters",
            "400",
            ex.getClass().getName(),
            ex.getMessage(),
            Arrays.stream(ex.getStackTrace()).map(String::valueOf).toList()
        );

        return handleExceptionInternal(ex, res, headers, HttpStatusCode.valueOf(400), request);
    }

    @ExceptionHandler(value = { MissingRequestHeaderException.class })
    public ResponseEntity<Object> handle(MissingRequestHeaderException ex, WebRequest request) {
        ApiErrorResponse res = new ApiErrorResponse(
            "Invalid request parameters",
            "400",
            ex.getClass().getName(),
            ex.getMessage(),
            Arrays.stream(ex.getStackTrace()).map(String::valueOf).toList()
        );

        return handleExceptionInternal(ex, res, new HttpHeaders(), HttpStatusCode.valueOf(400), request);
    }
}
