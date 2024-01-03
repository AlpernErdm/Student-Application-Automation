package codeDev.io.ogrenciBasvuru.core.exceptions;

public class YouDoNotHavePermission extends  RuntimeException{
    public YouDoNotHavePermission(String message){
        super(message);
    }
}
