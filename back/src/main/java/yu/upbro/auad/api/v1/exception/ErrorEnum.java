package yu.upbro.auad.api.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorEnum {
    TEST_ERROR(400,"400_1", "ERROR_ENUM_TEST");

    private final int status;
    private final String errorCode;
    private final String message;
}
