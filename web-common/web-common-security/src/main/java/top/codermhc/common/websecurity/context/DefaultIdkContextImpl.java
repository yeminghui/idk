package top.codermhc.common.websecurity.context;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import top.codermhc.common.websecurity.entity.User;

@Component
@ConditionalOnBean(IdkContext.class)
@Scope("prototype")
public class DefaultIdkContextImpl implements IdkContext {
    @Override
    public User getCurrentUser() {
        return null;
    }
}
