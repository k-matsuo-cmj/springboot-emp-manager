package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.repository.EmployeeRepository;
import jp.co.cybermissions.itspj.java.empmanager.service.ProfileService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

  private final EmployeeRepository rep;

  @Override
  public Employee getLoginProfile() {
    // ログイン情報を取得する
    String loginId = getLoginId();
    // 従業員情報を取得する
    Employee emp = rep.findByLoginId(loginId);
    return emp;
  }

  /** 現在ログイン中のログインIDを取得する */
  private String getLoginId() {
    // UserDetails.nameにloginIdが格納されている
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String loginId = auth.getName();
    return loginId;
  }
}
