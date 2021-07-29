package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import jp.co.cybermissions.itspj.java.empmanager.service.ProfileService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

  private final EmployeeRepository rep;

  private final PasswordEncoder passwordEncoder;

  @Override
  public Employee getLoginProfile() {
    // ログイン中の従業員情報を取得する
    Employee emp = getLoginEmployee();
    return emp;
  }

  /** 現在ログイン中の従業員を取得する */
  private Employee getLoginEmployee() {
    // UserDetails.nameにloginIdが格納されている
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String loginId = auth.getName();
    // 従業員情報を取得する
    Employee emp = rep.findByLoginId(loginId);
    return emp;
  }

  @Override
  public void updateLoginProfile(Employee emp) {
    // ログイン中の従業員情報を取得する
    Employee baseEmp = getLoginEmployee();

    // 画面の情報を設定する
    baseEmp.setName(emp.getName());
    baseEmp.setKana(emp.getKana());
    baseEmp.setEmail(emp.getEmail());
    baseEmp.setMainGroup(emp.getMainGroup());
    // パスワード
    String rawPassword = emp.getPassword();
    if (!rawPassword.isBlank()) {
      baseEmp.setPassword(passwordEncoder.encode(rawPassword));
    }

    // 従業員情報の更新
    rep.save(baseEmp);
  }
}
