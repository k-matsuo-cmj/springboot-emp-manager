package jp.co.cybermissions.itspj.java.empmanager.service;

import jp.co.cybermissions.itspj.java.empmanager.model.Employee;

public interface ProfileService {

  /** ログインしている従業員の情報を取得する */
  public Employee getLoginProfile();

  /** ログインしている従業員の情報を更新する */
  public void updateLoginProfile(Employee emp);
}
