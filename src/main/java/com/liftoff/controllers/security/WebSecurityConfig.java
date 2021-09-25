package com.liftoff.controllers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/account/manageUsers/**",
                                        "/account/manageLinks/**",
                                        "/account/manageWantTos/**",
                                        "/account/manageFaqs/**",
                                        "/account/manageWelcome/**").hasAnyAuthority("ADMIN","EDITOR")
                .antMatchers("/account/**").authenticated()
                .antMatchers("/","/about","/register","/login","/contact","/verify","/forgot_password","/reset_password","/fragments","/message").permitAll()
                .antMatchers("/message/**","/help/**","/wantTo/**","/css/**","/img/**","/js/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/account",true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .formLogin().permitAll()
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("2a10F47xKtCXMYVoJ57fsi0nVzoUZOmgf7pgbboAbDDjPds3X4mKAK")
                    .rememberMeParameter("remember-me")
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/messages/403")
                ;
    }
}
