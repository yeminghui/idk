package top.codermhc.common.result;

/**
 * @author yemh
 */
public enum DefaultResultStatus implements ResultStatus {
    /**
     * 成功
     */
    SUCCESS(20000),
    /**
     * 客户端问题
     */
    FAIL(40000),
    /**
     * 服务器端问题
     */
    ERROR(50000);

    private final int code;

    DefaultResultStatus(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return this.name();
    }
}
