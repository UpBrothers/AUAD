package yu.upbro.auad.api.v1.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ExceptionModel> ExceptionHandler(CustomException e){
        logger.error(e.errorEnum.getMessage());
        return ResponseEntity.status(e.errorEnum.getStatus()).body(ExceptionModel.of(e.errorEnum));
    }
}
