package com.aaa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

// 将当前类作为配置类使用
@Configuration
// 启用security
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /***
     * 设置请求处理方式
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 使用form表单登录
        http.formLogin()
                // 设置登录页面
                .loginPage("/login.html")
                // 表单提交路径
                .loginProcessingUrl("/login-check")
                .usernameParameter("cname")
                .passwordParameter("pwd")
                // 默认成功路径：登录后有目标资源，访问目标资源，没有跳转默认成功路径
                .defaultSuccessUrl("/success")
                // 失败路径
                .failureUrl("/fail")
                // 已认证，不需要身份验证
                .permitAll()
                .and()
                // 授权请求：设置如何让处理请求
                .authorizeRequests()
                // 任意请求
                .anyRequest()
                // 认证
                .authenticated()
                .and()
                // 跨域请求
                .csrf()
                .disable();
    }



    @Resource
    UserConfig userConfig;

    /**
     * 认证校验工作
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                // 密码编码器
                .passwordEncoder(new PasswordConfig())
                .withUser("zs").password("123").roles("admin")
                .and()
                .withUser("ls").password("111").roles("admin");*/
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // 密码编码器
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        // 设置用户详细信息的获取方式
        daoAuthenticationProvider.setUserDetailsService(userConfig);

        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
