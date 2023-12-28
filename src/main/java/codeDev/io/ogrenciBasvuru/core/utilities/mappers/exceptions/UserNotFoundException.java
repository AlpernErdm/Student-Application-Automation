package codeDev.io.ogrenciBasvuru.core.utilities.mappers.exceptions;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
