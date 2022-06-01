package yu.upbro.auad.api.v1.exception;

public class CustomException extends RuntimeException{
    public ErrorEnum errorEnum;
    public CustomException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
    }
}