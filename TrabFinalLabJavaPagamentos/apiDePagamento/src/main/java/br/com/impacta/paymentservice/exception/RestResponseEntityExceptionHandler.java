package br.com.impacta.paymentservice.exception;

import br.com.impacta.paymentservice.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParameterException.class)
    public final ResponseEntity<Object> handleParametroIncorreto(ParameterException e, WebRequest req){
        Response ex = new Response(LocalDateTime.now(), e.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handleRegistroNaoEncontrado(EntityNotFoundException e, WebRequest req){
        Response ex = new Response(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerException.class)
    public final ResponseEntity<Object> handleServe(ServerException e, WebRequest req){
        Response ex = new Response(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
