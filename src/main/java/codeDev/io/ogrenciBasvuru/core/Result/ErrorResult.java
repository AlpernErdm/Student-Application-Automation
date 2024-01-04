package codeDev.io.ogrenciBasvuru.core.Result;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(true);
    }

    public ErrorResult(String message) {
        super(true,message);
    }

    public ErrorResult(String message, int code) {
        super(true, message, code);
    }
}
