package jp.com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    /**
     * 認証の設定
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.formLogin(login -> 
            login.loginProcessingUrl("/login")
            .usernameParameter("user")
            .passwordParameter("password")
            .permitAll()// ログインAPIへのアクセスを常に許可する
        ).logout(logout -> 
            logout.logoutUrl("/logout").permitAll()// ログアウトをトリガーする 
        ).authorizeRequests(authorize ->
            authorize.mvcMatchers("/checkAuthorize").permitAll() // 認証確認APIへのアクセスは常にOK
            .anyRequest().authenticated() // ログイン/ログアウト以外のapiアクセスはログイン後のみ可能とする。
        );
        return http.build();
	}

    /**
     * パスワードのHash化
     * @return
     */
    // @Bean
    // public PasswordEncoder passwordEncoder(){
    //     return new BCryptPasswordEncoder();
    // } 
}
