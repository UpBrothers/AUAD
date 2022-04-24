package yu.upbro.auad.api.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.upbro.auad.api.v1.exception.ErrorEnum;

@RestController
@RequestMapping(path = "/api/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(path = "/t1")
    public ResponseEntity testAPI1(){
        logger.info("test API1");
        return ResponseEntity.status(HttpStatus.OK).body("AUAD TEST API");
    }

    @GetMapping(path = "/t2")
    public ResponseEntity testAPI2(){
        logger.info("test API2");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorEnum.TEST_ERROR.getMessage());
    }

    @GetMapping(path = "/t3")
    public ResponseEntity testAPI3(){
        logger.info("test API3");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ISE");
    }
}
