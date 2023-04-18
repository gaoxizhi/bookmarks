package net.gaox.bookmark.config;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * <p> swagger2 配置类及开关 </p>
 *
 * @author gaox·Eric
 * @date 2023-04-18 22:33
 */
@Configuration
@ConditionalOnExpression("!${dev:true}")
public class Swagger2Config implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources");
    }

    @Bean
    public Docket api() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                // 选择包路径
                .apis(RequestHandlerSelectors.basePackage("net/gaox/bookmark/controller"))
                // 不显示错误的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(Predicates.not(PathSelectors.regex("/bookmark.*")))
                .build();

        return docket;
    }

    /**
     * 配置文档信息
     *
     * @return info
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("高羲之", "http://me.gaox.net", "admin@gaox.net");
        return new ApiInfo(
                "书签管理 API文档",
                "书签管理平台 API 集合",
                "v1.0",
                "http://gaox.net",
                contact,
                "Apach 2.0 许可",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}
