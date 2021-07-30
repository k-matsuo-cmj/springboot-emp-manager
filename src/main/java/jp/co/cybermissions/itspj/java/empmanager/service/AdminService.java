package jp.co.cybermissions.itspj.java.empmanager.service;

import java.util.List;

import jp.co.cybermissions.itspj.java.empmanager.model.Group;

public interface AdminService {

  /** グループの一覧を取得する */
  List<Group> getGroupList();
}
