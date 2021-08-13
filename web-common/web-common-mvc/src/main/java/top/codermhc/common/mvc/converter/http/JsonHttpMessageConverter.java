package top.codermhc.common.mvc.converter.http;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * @author yemh
 */
@Component
public class JsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    /**
     * 支持返回值类型为void的handler
     * @param clazz 返回值类型
     * @return true if this converter supports the clazz, else false.
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return Void.TYPE.equals(clazz) || super.supports(clazz);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.APPLICATION_JSON);
    }

    {
        FastJsonConfig fastJsonConfig = getFastJsonConfig();
        fastJsonConfig.setFeatures(Feature.OrderedField);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        setDefaultCharset(StandardCharsets.UTF_8);
    }

}
