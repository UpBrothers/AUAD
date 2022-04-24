package yu.upbro.auad.api.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.upbro.auad.api.v1.dto.request.user.SignInDTO;
import yu.upbro.auad.api.v1.entity.User;
import yu.upbro.auad.api.v1.exception.BadRequestException;
import yu.upbro.auad.api.v1.exception.ErrorEnum;
import yu.upbro.auad.api.v1.repository.UserRepository;

@Service
public class LoginService {
    private final UserRepository userRepository;

    @Autowired
    LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signIn(SignInDTO signinDTO){
        User user = userRepository.findByStudentId(signinDTO.getId())
                .orElseThrow(RuntimeException::new);
        if (!user.getPwd().equals(signinDTO.getPwd())){
            throw new BadRequestException(ErrorEnum.TEST_ERROR);
        }
        return user;
    }
}
