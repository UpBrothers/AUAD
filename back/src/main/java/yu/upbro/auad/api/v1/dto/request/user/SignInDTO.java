package yu.upbro.auad.api.v1.dto.request.user;

import lombok.Data;

@Data
public class SignInDTO {
    String studentId;
    String pwd;
}