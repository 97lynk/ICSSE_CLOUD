package com.t2p.config;

import com.a97lynk.config.SecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class IcsseConfig extends SecurityConfig {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // bỏ qua csrf cho form đăng kí
//        http.csrf().ignoringAntMatchers("/u/registration");

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/u/login", "/u/logout").permitAll();

        // yêu cầu quyền
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/u/changePassword*").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/u/changePassword*")
                .hasAuthority("CHANGE_OWN_PASSWORD");

        // Trang /tnfo yêu cầu phải login
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests()
                .antMatchers("/u/info", "/edit/**").hasAuthority("READ_INFO");

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

