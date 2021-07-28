package jp.co.cybermissions.itspj.java.empmanager.service.impl;

import org.springframework.stereotype.Service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;
import jp.co.cybermissions.itspj.java.empmanager.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Override
  public Employee getLoginProfile() {
    // ログイン情報を取得する
    // 従業員情報を取得する
    Employee emp = new Employee(); // TODO
    return emp;
  }

}
