package yu.upbro.auad.api.v1.dto.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("회원가입 DTO")
public class SignUpDTO {

    @ApiModelProperty(name="studentId", notes = "로그인 ID")
    String studentId;

    @ApiModelProperty(name="pwd", notes = "로그인 PWD")
    String pwd;

    @ApiModelProperty(name="name", notes = "사용자 이름")
    String name;

    @ApiModelProperty(name="type", notes = "사용자 유형")
    String type;
}
