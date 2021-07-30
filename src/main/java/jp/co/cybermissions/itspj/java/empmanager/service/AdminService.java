package jp.co.cybermissions.itspj.java.empmanager.service;

import java.util.List;

import jp.co.cybermissions.itspj.java.empmanager.form.EmployeeForm;
import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface AdminService {

  /** グループの一覧を取得する */
  List<Group> getGroupList();

  /** 従業員情報を登録する */
  void createEmployee(EmployeeForm form);

  /** 従業員情報を削除する */
  void deleteEmployee(int id);
}
