package br.com.estudiobdd.exception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(EntityNotFoundException.class) public ProblemDetail notFound(EntityNotFoundException e){return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler({IllegalArgumentException.class,IllegalStateException.class}) public ProblemDetail regra(RuntimeException e){return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ProblemDetail validacao(MethodArgumentNotValidException e){String d=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).reduce((a,b)->a+"; "+b).orElse("Dados inválidos");return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,d);}
}
