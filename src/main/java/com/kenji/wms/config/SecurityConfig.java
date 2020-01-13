//package com.kenji.wms.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()  //定义哪些url需要保护，哪些url不需要保护
//                .antMatchers("/", "/message/").permitAll()    //定义不需要认证就可以访问
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")  //定义当需要用户登录时候，转到的登录页面
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        http.csrf().disable();
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//        //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
//    }
//}
