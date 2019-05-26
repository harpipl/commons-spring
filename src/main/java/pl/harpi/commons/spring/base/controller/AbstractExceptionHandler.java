package pl.harpi.commons.spring.base.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.harpi.commons.spring.base.dto.ExceptionDto;
import pl.harpi.commons.spring.base.dto.MultiExceptionDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public abstract class AbstractExceptionHandler {
    protected abstract MessageSource getMessageSource();

    protected ResponseEntity onException(Exception ex, HttpStatus status, Locale locale) {
        String exceptionName = ex.getClass().getSimpleName();
        String description;
        try {
            description = getMessageSource().getMessage(ex.getClass().getSimpleName(), null, locale);
        } catch (NoSuchMessageException exception) {
            description = exceptionName;

        }
        return ResponseEntity.status(status).body(new ExceptionDto(null, description));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity onConstraintViolationException(ConstraintViolationException ex, Locale locale) {
        return createResponseFromConstraintViolation(ex, BAD_REQUEST, locale);
    }

    private ResponseEntity createResponseFromConstraintViolation(ConstraintViolationException ex, HttpStatus status, Locale locale) {
        List<ExceptionDto> exceptionDtos = new ArrayList<>();

        for (ConstraintViolation<?> cv : ex.getConstraintViolations()) {
            exceptionDtos.add(new ExceptionDto(cv.getPropertyPath().toString(), cv.getMessage()));
        }

        return ResponseEntity.status(status).body(new MultiExceptionDto(exceptionDtos));
    }
}
