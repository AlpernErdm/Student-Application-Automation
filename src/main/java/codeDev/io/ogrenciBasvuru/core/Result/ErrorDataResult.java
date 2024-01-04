package codeDev.io.ogrenciBasvuru.core.Result;

import java.util.Map;

public class ErrorDataResult<T> extends DataResult<T>{

    private Map<String, String> errorFields;

    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult() {
        super(null, false);
    }

    public ErrorDataResult(String message) {
        super(null, false, message);
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data, String message, int code) {
        super(data, false, message, code);
    }

    public ErrorDataResult(T data, String message, int code, Map<String, String> erroFields) {
        super(data, false, message, code);
    }

    public Map<String, String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(Map<String, String> errorFields) {
        this.errorFields = errorFields;
    }

}


