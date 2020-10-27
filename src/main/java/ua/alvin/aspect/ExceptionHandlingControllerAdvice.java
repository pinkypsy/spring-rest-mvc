package ua.alvin.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.alvin.entity.StudentErrorResponseEntity;
import ua.alvin.exception.StudentNotFoundException;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponseEntity> handleException(StudentNotFoundException exc){

        StudentErrorResponseEntity studentErrorResponseEntity = new StudentErrorResponseEntity();
        studentErrorResponseEntity.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponseEntity.setMessage(exc.getMessage());
        studentErrorResponseEntity.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponseEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponseEntity> handleException(Exception exc){

        StudentErrorResponseEntity studentErrorResponseEntity = new StudentErrorResponseEntity();
        studentErrorResponseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponseEntity.setMessage(exc.getMessage());
        studentErrorResponseEntity.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponseEntity, HttpStatus.BAD_REQUEST);
    }
}
