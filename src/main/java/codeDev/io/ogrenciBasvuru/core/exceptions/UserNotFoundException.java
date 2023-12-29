package codeDev.io.ogrenciBasvuru.core.exceptions;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
