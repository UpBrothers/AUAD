package yu.upbro.auad.api.v1.exception;

public class BadRequestException extends RuntimeException{
    public ErrorEnum errorEnum;
    public BadRequestException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
    }
}
