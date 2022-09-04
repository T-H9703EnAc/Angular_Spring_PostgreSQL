package jp.com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/*/*").permitAll().anyRequest().authenticated();
                return http.build();
	}
}
