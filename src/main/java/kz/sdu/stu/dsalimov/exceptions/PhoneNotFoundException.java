package kz.sdu.stu.dsalimov.exceptions;

public class PhoneNotFoundException extends ServiceException{
    public PhoneNotFoundException() {
        super();
    }

    public PhoneNotFoundException(String message) {
        super(message);
    }

    public PhoneNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
