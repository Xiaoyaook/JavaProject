package com.xiaoyaook.tryactuator.config;

import org.springframework.context.annotation.Configuration;

/**
 * created by xiaoyaook on 18-9-9
 */
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }
}
