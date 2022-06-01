package yu.upbro.auad.api.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorEnum {
    // 400
    TEST_ERROR(HttpStatus.BAD_REQUEST,"400_1", "ERROR_ENUM_TEST");

    // 401

    // 403

    // 404

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
