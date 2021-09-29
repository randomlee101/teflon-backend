package com.randomlee.teflonbackend.security_config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Data
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails userDetails = User.builder()
                .username("teflon")
                .password(passwordEncoder.encode("newuser"))
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                        .csrf().disable()
                        .antMatcher("/api/**")
                        .authorizeRequests()
                        .antMatchers(HttpMethod.POST,"/api/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .httpBasic();
    }
}
