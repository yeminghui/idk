package top.codermhc.common.result;

/**
 * @author yemh
 */
public interface ResultStatus {

    /**
     * 获取状态名称
     * @return name of status
     */
    String getName();

    /**
     * 获取状态值
     * @return code of status
     */
    int getCode();
}
