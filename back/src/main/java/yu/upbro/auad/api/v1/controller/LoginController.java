package yu.upbro.auad.api.v1.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.upbro.auad.api.v1.dto.request.user.SignInDTO;
import yu.upbro.auad.api.v1.dto.request.user.SignUpDTO;
import yu.upbro.auad.api.v1.entity.User;
import yu.upbro.auad.api.v1.service.LoginService;

@RestController
@RequestMapping(path = "/api/v1/user")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping(path = "/signin")
    @ApiOperation(value = "로그인")
    public ResponseEntity signIn(
            @RequestBody
                    SignInDTO signinDTO
    ){
        logger.info("[SignIn] ID : {} , PW : {}", signinDTO.getStudentId(), signinDTO.getPwd());
        User user = loginService.signIn(signinDTO);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping(path = "/signup")
    @ApiOperation(value = "회원가입")
    public ResponseEntity signUp(
            @RequestBody
                    SignUpDTO signUpDTO
    ){
        logger.info("[SignUp] ID : {} , PW : {}", signUpDTO.getStudentId(), signUpDTO.getPwd());

        User user = loginService.signUp(signUpDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
