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

  /** グループを取得する */
  Group getGroup(int id);

  /** グループを登録する */
  void createGroup(Group group);

  /** グループを更新する */
  void updateGroup(int id, Group group);

  /** グループを削除する */
  void deleteGroup(int id);
}
