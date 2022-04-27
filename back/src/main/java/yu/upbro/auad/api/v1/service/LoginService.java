package yu.upbro.auad.api.v1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.upbro.auad.api.v1.controller.LoginController;
import yu.upbro.auad.api.v1.dto.request.user.SignInDTO;
import yu.upbro.auad.api.v1.dto.request.user.SignUpDTO;
import yu.upbro.auad.api.v1.entity.User;
import yu.upbro.auad.api.v1.exception.BadRequestException;
import yu.upbro.auad.api.v1.exception.ErrorEnum;
import yu.upbro.auad.api.v1.repository.UserRepository;

@Service
public class LoginService {
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signIn(SignInDTO signinDTO){
        User user = userRepository.findByStudentId(signinDTO.getStudentId())
                .orElseThrow(RuntimeException::new); // TODO 404 UserNotFound Exception
        if (!user.getPwd().equals(signinDTO.getPwd())){
            throw new BadRequestException(ErrorEnum.TEST_ERROR); // TODO 401 Authentication Exception
        }
        return user;
    }

    public User signUp(SignUpDTO signUpDTO){
        User user = User.builder()
                .name(signUpDTO.getName())
                .studentId(signUpDTO.getStudentId())
                .pwd(signUpDTO.getPwd()) // TODO pwd Encryption
                .type(signUpDTO.getType())
                .build();

        return userRepository.save(user);
    }
}
