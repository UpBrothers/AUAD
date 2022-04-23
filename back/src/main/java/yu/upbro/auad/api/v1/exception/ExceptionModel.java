package yu.upbro.auad.api.v1.exception;

import lombok.Data;

@Data
public class ExceptionModel {
    private final int status;
    private final String errorCode;
    private final String message;

    public static ExceptionModel of(ErrorEnum e){
        return new ExceptionModel(e.getStatus(),e.getErrorCode(), e.getMessage());
    }
}
