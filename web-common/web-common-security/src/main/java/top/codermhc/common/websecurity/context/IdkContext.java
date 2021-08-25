package top.codermhc.common.websecurity.context;

import top.codermhc.common.websecurity.entity.User;

/**
 * @author yemh
 */
public interface IdkContext {

    /**
     * 获取当前登陆用户
     * @return 用户信息
     */
    User getCurrentUser();

}
