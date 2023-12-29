package codeDev.io.ogrenciBasvuru.core.exceptions;

public class NoPersonWithThisId extends RuntimeException{
    public NoPersonWithThisId(String message){
        super(message);
    }
}
