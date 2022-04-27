package yu.upbro.auad.api.v1.dto.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("로그인 시도 DTO")
public class SignInDTO {

    @ApiModelProperty(name="studentId", notes = "로그인 ID")
    String studentId;

    @ApiModelProperty(name="pwd", notes = "로그인 PWD")
    String pwd;
}