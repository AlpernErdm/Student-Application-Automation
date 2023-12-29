package codeDev.io.ogrenciBasvuru.core.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
