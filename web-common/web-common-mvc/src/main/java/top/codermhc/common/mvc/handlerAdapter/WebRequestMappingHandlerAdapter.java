package top.codermhc.common.mvc.handlerAdapter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import top.codermhc.common.mvc.converter.http.JsonHttpMessageConverter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author yemh
 */
@Component
public class WebRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    @Resource
    private WebBindingInitializer webBindingInitializer;
    @Resource
    private JsonHttpMessageConverter jsonHttpMessageConverter;

    @PostConstruct
    private void init() {
        getMessageConverters().add(jsonHttpMessageConverter);
        setWebBindingInitializer(webBindingInitializer);
    }

}
