package top.codermhc.common.websecurity.filter;

import org.springframework.stereotype.Component;
import top.codermhc.common.websecurity.context.IdkContext;
import top.codermhc.common.websecurity.context.IdkContextHolder;
import top.codermhc.common.websecurity.context.SpringSecurityIdkContextImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yemh
 */
@Component
@WebFilter
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        IdkContext idkContext = new SpringSecurityIdkContextImpl();
        IdkContextHolder.setContext(idkContext);
        chain.doFilter(request,response);
        IdkContextHolder.clear();
    }

}
