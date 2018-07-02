package luffy.config;

import luffy.interceptor.URLInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description 拦截器配置
 * @fiel luffy.config.InterceptorConfig
 * @author Jimmy
 * @date 2018-07-02 15:58:50
 */
@Configuration
public class InterceptorConfig  extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor())
                .addPathPatterns("/index/**")  // 拦截路径
                .excludePathPatterns("/login.html", "/login/**"); // 放行
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); // 静态资源
        super.addResourceHandlers(registry);
    }

    @Bean
    public URLInterceptor userInterceptor() {
        return new URLInterceptor();
    }
}