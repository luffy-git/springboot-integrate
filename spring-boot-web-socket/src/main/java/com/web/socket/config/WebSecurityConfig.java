package com.web.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description
 * @Fiel com.web.socket.config.WebSecurityConfig
 * @Author jaood
 * @Date 2017/8/10 14:50
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * @Description 配置默认的拦截
     * @Author jaood
     * @Date 2017/8/10 14:51
     * @Param [http]
     * @Return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll()//根路径和/login路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //2登陆页面路径为/login
                .defaultSuccessUrl("/chat") //3登陆成功转向chat页面
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    /**
     * @Description 在内存中配置两个用户 wyf 和 wisely ,密码和用户名一致,角色是 USER
     * @Author jaood
     * @Date 2017/8/10 14:51
     * @Param [auth]
     * @Return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }

    /**
     * @Description 略静态资源的拦截
     * @Author jaood
     * @Date 2017/8/10 14:51
     * @Param [web]
     * @Return void
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
