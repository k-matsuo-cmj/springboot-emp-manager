package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.form.ProfileForm;
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
  public ProfileForm getLoginProfile() {
    // ログイン中の従業員情報を取得する
    Employee emp = getLoginEmployee();

    // emp->formに変換
    ProfileForm form = new ProfileForm();
    form.setName(emp.getName());
    form.setKana(emp.getKana());
    form.setLoginId(emp.getLoginId());
    form.setEmail(emp.getEmail());
    form.setPassword(null); // 渡さない
    form.setPasswordConfirm(null);
    form.setGroups(new ArrayList<>(emp.getGroups()));
    form.setMainGroup(emp.getMainGroup());

    return form;
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
  public void updateLoginProfile(ProfileForm form) {
    // ログイン中の従業員情報を取得する
    Employee baseEmp = getLoginEmployee();

    // 画面の情報を設定する
    baseEmp.setName(form.getName());
    baseEmp.setKana(form.getKana());
    baseEmp.setEmail(form.getEmail());
    baseEmp.setMainGroup(form.getMainGroup());
    // パスワード
    String rawPassword = form.getPassword();
    if (!rawPassword.isBlank()) {
      baseEmp.setPassword(passwordEncoder.encode(rawPassword));
    }

    // 従業員情報の更新
    rep.save(baseEmp);
  }
}
