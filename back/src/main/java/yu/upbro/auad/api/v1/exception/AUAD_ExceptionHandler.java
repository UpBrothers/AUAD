package yu.upbro.auad.api.v1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AUAD_ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AUAD_ExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> ExceptionHandler(BadRequestException e){

        // TODO [Refactoring] apply Design Pattern
        logger.error(e.errorEnum.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionModel.of(e.errorEnum));
    }
}
