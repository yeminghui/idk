package top.codermhc.common.websecurity.filter;

import top.codermhc.common.websecurity.context.IdkContext;
import top.codermhc.common.websecurity.context.IdkContextHolder;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

public class UserContextFilter implements Filter {

    @Resource
    private IdkContext idkContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (IdkContextHolder.getContext() != null) {
            IdkContextHolder.setContext(idkContext);
        }
    }
}
