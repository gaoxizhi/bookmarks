package site.gaox.bookmark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，
 * 等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
 *
 * @author: gaox·Eric
 */
@SpringBootApplication
@MapperScan({"site.gaox.bookmark.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
