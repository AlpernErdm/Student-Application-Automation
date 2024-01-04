package codeDev.io.ogrenciBasvuru.core.Result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Result {
    private boolean success;//success-
    private String message;
    private int code;

    public Result(boolean success) { //single parameter ctor
        this.success = success;
    }

    public Result(boolean success, String message) { //double parameter ctor
        this.success = success;
        this.message = message;
    }

    public Result(boolean success, String message, int code) { //triple ctor
        super();
        this.message = message;
        this.success = success;
        this.code = code;
    }

    public String getMessage(String message) { //değer döndürmez sadece mesajı alır
        return message;
    }

    public void setMessage(String message) { //mesajı döndürmemizi sağlar
        this.message = message;
    }

    public boolean isSuccess(boolean success) {
        return success;
    }


}
