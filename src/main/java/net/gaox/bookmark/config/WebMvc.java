package net.gaox.bookmark.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import net.gaox.bookmark.config.interceptor.LoggingInterceptor;
import net.gaox.bookmark.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p> mvc 配置 </p>
 *
 * @author: gaox·Eric
 * @date 2023-03-31 23:18
 */
@Configuration
public class WebMvc implements WebMvcConfigurer {

    /**
     * 配置拦截器
     *
     * @param registry 相当于拦截器的注册中心
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截器
        registry.addInterceptor(new LoggingInterceptor())
                // 拦截所有请求，包括静态资源
                .addPathPatterns("/**");

        // 登陆拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                // 放行静态资源等
                .excludePathPatterns("/", "/error", "/login");
    }

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
                , SerializerFeature.WriteNullBooleanAsFalse
                , SerializerFeature.WriteNullNumberAsZero
                , SerializerFeature.WriteNullStringAsEmpty
                , SerializerFeature.WriteMapNullValue
                , SerializerFeature.WriteNonStringKeyAsString
                , SerializerFeature.DisableCircularReferenceDetect
        );
        return fastJsonConfig;
    }

}
