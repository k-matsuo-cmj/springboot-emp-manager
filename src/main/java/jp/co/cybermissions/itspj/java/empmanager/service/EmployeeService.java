package jp.co.cybermissions.itspj.java.empmanager.service;

import java.util.List;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface EmployeeService {
  
  /** グループ一覧を取得する */
  public List<Group> getGroupList();
}
