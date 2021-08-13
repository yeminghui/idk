package top.codermhc.common.result;

/**
 * @author yemh
 */
public class ResponseWrapper<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(ResultStatus status) {
        this.code = status.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseWrapper<T> success(T data) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.setCode(DefaultResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ResponseWrapper<T> fail(String msg) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.setCode(DefaultResultStatus.FAIL);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResponseWrapper<T> error(String msg) {
        ResponseWrapper<T> result = new ResponseWrapper<>();
        result.setCode(DefaultResultStatus.ERROR);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResponseWrapperBuilder<T> builder() {
        return new ResponseWrapperBuilder<>();
    }

    public static class ResponseWrapperBuilder<T> {

        private final ResponseWrapper<T> result = new ResponseWrapper<>();

        public ResponseWrapper<T> build() {
            return result;
        }

        public ResponseWrapperBuilder<T> code(int code) {
            result.setCode(code);
            return this;
        }

        public ResponseWrapperBuilder<T> code(ResultStatus code) {
            result.setCode(code);
            return this;
        }

        public ResponseWrapperBuilder<T> data(T data) {
            result.setData(data);
            return this;
        }

        public ResponseWrapperBuilder<T> msg(String message) {
            result.setMessage(message);
            return this;
        }
    }

}
