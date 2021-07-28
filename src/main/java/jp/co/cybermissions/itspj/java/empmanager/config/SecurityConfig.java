package jp.co.cybermissions.itspj.java.empmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

/**
 * Spring Security 設定クラス
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // パスワードエンコーダ
    PasswordEncoder enc = passwordEncoder();
    // 認証
    auth.userDetailsService(userDetailsService).passwordEncoder(enc);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // セキュリティ設定対象外を指定
    web.ignoring().antMatchers("/h2-console/**").antMatchers("/webjars/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ログイン不要ページの設定
    http.authorizeRequests() //
        .antMatchers("/login").permitAll() // ログイン画面だけログイン不要
        .anyRequest().authenticated();
    // ログイン処理
    http.formLogin().loginProcessingUrl("/login") // URL
        .defaultSuccessUrl("/emp"); // ログイン成功時のURL
  }

}
