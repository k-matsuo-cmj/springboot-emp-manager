package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final EmployeeRepository rep;

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    // データベースからlogin_idの情報を取得する
    // 従業員の情報取得
    Employee emp = rep.findByLoginId(loginId);
    if (emp == null) {
      // 存在しない場合
      throw new UsernameNotFoundException("user not found.");
    }
    // 権限
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (emp.isAdmin()) {
      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    // UserDetailsのインスタンスを返す
    UserDetails userDetails = new User(loginId, emp.getPassword(), authorities);
    return userDetails;
  }

}
