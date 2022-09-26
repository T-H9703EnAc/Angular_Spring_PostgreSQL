package jp.com.app.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
        System.out.println("********************************************************************************");
        System.out.println(http);
        System.out.println("********************************************************************************");
        http.formLogin(login -> 
            login
            .loginPage("http://localhost:4200/api/loginPage") // カスタムページ
            .loginProcessingUrl("/login")
            .successForwardUrl("http://localhost:4200/home")
            .failureForwardUrl("http://localhost:4200/home")
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

    @Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		/* Access-Control-Allow-Origin : オリジンの許可 */
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://localhost:4200"));
        
        /* Access-Control-Allow-Headers */
        configuration.setAllowedHeaders(Arrays.asList("*"));

        /* Access-Control-Allow-Methods : 通信自に使用するメソッドの許可 */
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));

        /* Access-Control-Allow-Credentials : クッキーの送信またはBASIC認証の有無*/
        configuration.setAllowCredentials(false);

        /* Access-Control-Expose-Headers */
        configuration.setExposedHeaders(Arrays.asList("*"));

        /* Access-Control-Max-Age : プリフライトリクエストの結果をキャッシュできる時間 */
        configuration.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configuration);
		
        return source;
	}

    /**
     * パスワードのHash化
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } 
}
