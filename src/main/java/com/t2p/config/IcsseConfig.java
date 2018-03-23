package com.t2p.config;

import com.a97lynk.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IcsseConfig extends SecurityConfig {

    @Autowired
    private AuthenticationSuccessHandler authSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // bỏ qua csrf cho
//        http.csrf().ignoringAntMatchers("/edit/**", "/news/**", "/");
        http.csrf().disable();

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/u/login", "/u/logout").permitAll();

        // Khi người dùng đã login
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests()
                .and().exceptionHandling().accessDeniedPage("/u/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests()
                .and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/u/login")
                .successHandler(authSuccessHandler)
                //
                .defaultSuccessUrl("/")
                //
                .failureHandler(authFailureHandler)
                //
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                //...
                // cấu hình remember me
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me");
    }

}

