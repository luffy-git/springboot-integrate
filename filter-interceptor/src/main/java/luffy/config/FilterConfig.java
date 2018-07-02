package luffy.config;

import luffy.filter.CharSetFilter;
import luffy.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 注册过滤器
 * @fiel luffy.config.FilterConfig
 * @author Jimmy
 * @date 2018-07-02 15:44:18
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean loginFilterRegister() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LoginFilter());
        frBean.addUrlPatterns("/index/*");
        frBean.setOrder(1);  // 多个过滤器设置优先级别
        return frBean;
    }

    @Bean
    public FilterRegistrationBean charSetFilterRegister() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new CharSetFilter());
        frBean.addUrlPatterns("/index/*");
        frBean.setOrder(2);  // 多个过滤器设置优先级别
        return frBean;
    }

}
