package yu.upbro.auad.api.v1.dto.request.user;

import lombok.Data;

@Data
public class SignUpDTO {
    String studentId;
    String pwd;
    String name;
    String type;
}
