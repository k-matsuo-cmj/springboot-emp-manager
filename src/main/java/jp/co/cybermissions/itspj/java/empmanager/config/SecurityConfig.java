package jp.co.cybermissions.itspj.java.empmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 設定クラス
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 認証（とりあえず固定）
    auth.inMemoryAuthentication() // インメモリ認証
        .withUser("user").password("user").roles("USER") // 一般ユーザー
        .and() //
        .withUser("admin").password("admin").roles("ADMIN"); // 管理者ユーザー
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // TODO Auto-generated method stub
    super.configure(web);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ログイン不要ページの設定
    http.authorizeRequests() //
        .antMatchers("/login").permitAll() // ログイン画面だけログイン不要
        .anyRequest().authenticated();
    // ログイン処理
    http.formLogin().loginProcessingUrl("/login");
  }

}
