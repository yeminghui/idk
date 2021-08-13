package top.codermhc.common.websecurity.context;

import org.springframework.security.core.context.SecurityContextHolder;
import top.codermhc.common.websecurity.entity.User;

public class SpringSecurityIdkContextImpl implements IdkContext {

    @Override
    public User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
