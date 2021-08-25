package top.codermhc.common.websecurity.context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import top.codermhc.common.websecurity.entity.User;

import java.util.Optional;

/**
 * @author yemh
 */
public class SpringSecurityIdkContextImpl implements IdkContext {

    @Override
    public User getCurrentUser() {
        // null exp
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
