package codeDev.io.ogrenciBasvuru.core.Result;

public class SuccessResult extends Result{
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult(String message, int code) {
        super(true,message, code);
    }
}
