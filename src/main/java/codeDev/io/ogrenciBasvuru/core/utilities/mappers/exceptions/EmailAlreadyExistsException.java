package codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
