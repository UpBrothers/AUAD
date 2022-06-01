package yu.upbro.auad.api.v1.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionModel {
    private final String errorCode;
    private final String message;

    public static ExceptionModel of(ErrorEnum e){
        return ExceptionModel.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
    }
}
